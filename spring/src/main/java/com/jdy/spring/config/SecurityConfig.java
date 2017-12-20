package com.jdy.spring.config;

import com.jdy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        //web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/jdy").authenticated()
                .antMatchers("/**").permitAll();*/
        /*httpSecurity
                .csrf().disable().
                authorizeRequests().antMatchers("/login","/hello").permitAll();


        httpSecurity
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .defaultSuccessUrl("/loginCk")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();*/

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/loginCk", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(userService.passwordEncoder()) ;
    }

}
