package com.example.demo.DetailService;
import com.example.demo.bean.login;
import com.example.demo.bean.role;
import com.example.demo.bean.user;
import com.example.demo.bean.user_Page;
import com.example.demo.service.LoginService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserPageService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Author YYS
 * @Description //TODO  
 * @Date 23:39 23:39
 * @Param 
 * @return
 **/
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private UserService userService;

    @Autowired
    private RoleService roleService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserPageService userPageService;

    @Autowired
    LoginService loginService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("对用户 [{}] 进行信息加载...",username);

        user user = userService.findUserByUsername(username);
        /* 从数据库里面查出当前登录用户 */
        login login=loginService.getLoginByUserName(username);
        //登陆用户不存在，直接返回null,系统会直接抛出异常
        if(user==null){
            LOGGER.error("用户 [{}] 未找到",username);
            return null;
        }
        //以下两个是分别获取登陆用户的角色和权限，可以选择利用角色作为授权，或者权限作为授权
        Collection<GrantedAuthority> roleauthorities = new ArrayList<>();
        Collection<GrantedAuthority> pageauthorities = new ArrayList<>();
        //角色
        Set<role> roles = roleService.roles(username);
        //权限
        List<user_Page> user_pages = userPageService.user_Page_List(username);
        //将用户角色放入roleauthorities
        if(roles != null){
            for (role role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRolename());
                roleauthorities.add(authority);
            }
        }

        //将用户权限放入pageauthorities
        if (user_pages !=null && !user_pages.isEmpty()){
            for (user_Page userPage:user_pages){
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userPage.getRoleCode());
                pageauthorities.add(authority);
            }
        }
        //根据角色授权还是根据权限授权自己选
        UserDetails roleuserDetails = new User(login.getLoginusername(),bCryptPasswordEncoder.encode(login.getLoginpassword()),roleauthorities);
        UserDetails pageuserDetails = new User(login.getLoginusername(),bCryptPasswordEncoder.encode(login.getLoginpassword()),pageauthorities);
        LOGGER.info("用户 [{}] 信息加载完成",username);
        LOGGER.info("获取登录用户已具有的角色：{}", roleauthorities.toString());
        LOGGER.info("获取登录用户已具有的权限：{}", pageauthorities.toString());
        //返回userDetails
        return pageuserDetails;
    }
}

