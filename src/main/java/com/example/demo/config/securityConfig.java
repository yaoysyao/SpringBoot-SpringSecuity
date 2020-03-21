package com.example.demo.config;

import com.example.demo.DetailService.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName securityConfig
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/17 22:08
 * @Version 1.0
 */
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭防止跨站攻击
        http.csrf().disable();
        //授权
        //首页所有人可以访问，但是功能页只有有权限的人访问
        //这个配置写的不太完善，仅供参考
        http.authorizeRequests().antMatchers("/","/login","/index")
                .permitAll()
                .antMatchers("/index1/**").hasAuthority("P1")
                .antMatchers("/index2/**").hasAuthority("P2")
                .and()
                //登陆成功之后根据权限不同跳转至不同页面
//                .formLogin().loginPage("/login").successHandler(
//                        new AuthenticationSuccessHandler() {
//                            @Override
//                            public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
//                                    throws IOException, ServletException {
//                                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//                                if (principal != null && principal instanceof UserDetails) {
//                                    UserDetails user = (UserDetails) principal;
//                                    System.out.println("loginUser:"+user.getUsername());
//                                    //维护在session中
//                                    arg0.getSession().setAttribute("userDetail", user);
//                                    Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//                                    for (String role: roles){
//                                        System.out.println(role);
//                                        if (role.equals("P1")){
//                                            arg1.sendRedirect("/index1");
//                                        }else {
//                                            arg1.sendRedirect("/index2");
//                                        }
//                                    }
//                                }
//                            }
//                    })
                //登陆成功之后跳转至统一页面
                .formLogin().loginPage("/login").successForwardUrl("/index").failureForwardUrl("/loginerror")
                .and()
                .logout().logoutUrl("/");
        //开启记住我
        http.rememberMe();
    }

    //认证
    //There is no PasswordEncoder mapped for the id "null"
    //密码要加密，spring secutiry5.0中，新增了许多加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //基于内存的认证
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("yys1").password(new BCryptPasswordEncoder().encode("123456")).roles("P1")
//                .and()
//                .withUser("yys2").password(new BCryptPasswordEncoder().encode("123456")).roles("P2");
        //基于数据库的认证
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
