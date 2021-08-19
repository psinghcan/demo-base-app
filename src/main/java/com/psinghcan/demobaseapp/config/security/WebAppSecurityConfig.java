package com.psinghcan.demobaseapp.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

//    public WebAppSecurityConfig(AccessDeniedHandler accessDeniedHandler, AppUserAuthenticationService authenticationService){
//        this.accessDeniedHandler = accessDeniedHandler;
//        this.authenticationService = authenticationService;
//    }

    public WebAppSecurityConfig(AccessDeniedHandler accessDeniedHandler){
        this.accessDeniedHandler = accessDeniedHandler;
    }


    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user123").roles("USER");
        auth.inMemoryAuthentication()
                .withUser("biz1")
                .password("biz123").roles("BIZ1");
        auth.inMemoryAuthentication()
                .withUser("biz2")
                .password("biz123").roles("BIZ2");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin123").roles("USER", "BIZ1", "BIZ2", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/webjars/**", "/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("userpass")
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .defaultSuccessUrl("/secure/index", true).failureUrl("/public/authFailed")
                .and()
                .logout().logoutSuccessUrl("/public/logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder authMgrBuilder)
//            throws Exception
//    {
//        authMgrBuilder.authenticationProvider(authenticationService);
//    }

    private AccessDeniedHandler accessDeniedHandler;
//    private AppUserAuthenticationService authenticationService;

}
