/*
package com.example.walletsystem.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;


    @Bean
    public PasswordEncoder getPasswordEncoder()
    {

        DelegatingPasswordEncoder encoder=(DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return encoder;
    }

    */
/*@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/register","/login").permitAll().anyRequest().authenticated().and().formLogin();


        *//*
*/
/*http.authorizeRequests().antMatchers("/hello").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and().formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password").and()
                .logout().logoutSuccessUrl("/login?logout").and()
                .exceptionHandling().accessDeniedPage("/403").and().csrf();
*//*
*/
/*
    }
*//*


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

}
*/
