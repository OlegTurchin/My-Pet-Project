package org.example.Configurations;

import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception
//    {
//        httpSecurity.httpBasic().disable();
//    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/products/add_product/**").hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER")
                .antMatchers("/products/remove_product/**").hasAnyAuthority("ROLE_ADMINISTRATOR")
                .antMatchers("/products/update_product/**").hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER")
                .antMatchers("/products").hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER", "ROLE_BASIC_USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/products");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }
}
