//package eureka.client.main.configurations;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@AllArgsConstructor
//public class SecurityConfig {
//
//    private UserDetailsService userService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private DaoAuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception{
//        return httpSecurity.authorizeHttpRequests(matcherRegistry -> {
//                    matcherRegistry.requestMatchers("/products")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER", "ROLE_BASIC_USER");
//                    matcherRegistry.requestMatchers("/products/add_product/**")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER");
//                    matcherRegistry.requestMatchers("/products/remove_product/**")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR");
//                    matcherRegistry.requestMatchers("/products/update_product/**")
//                            .hasAnyAuthority("ROLE_ADMINISTRATOR", "ROLE_MANAGER"); })
//                .httpBasic(Customizer.withDefaults()).formLogin().permitAll()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/products")
//                .and()
//                .build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userService);
//        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
//        return authenticationProvider;
//    }
//}