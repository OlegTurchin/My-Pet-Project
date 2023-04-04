package eureka.client.security.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailsService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests(matcherRegistry -> {
                    matcherRegistry.requestMatchers(GET,"/api/token/refresh").permitAll();
                    matcherRegistry.requestMatchers(GET,"/api/users")
                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER", "ROLE_BASIC_USER");
//                    matcherRegistry.requestMatchers("/products")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER", "ROLE_BASIC_USER");
//                    matcherRegistry.requestMatchers("/products/add_product/**")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER");
//                    matcherRegistry.requestMatchers("/products/remove_product/**")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR");
//                    matcherRegistry.requestMatchers("/products/update_product/**")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER");
                            })
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilter(new CustomAuthenticationFilter(authenticationManager()))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout().logoutUrl("/logout").logoutSuccessUrl("/products")
                .and()
                .build();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }
}