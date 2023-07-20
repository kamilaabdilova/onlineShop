package com.example.onlineshop.config;

import com.example.onlineshop.service.impl.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private UserServiceIml userService;

    private JwtRequestFilter jwtRequestFilter;
    private AuthenticationProvider authenticationProvider;

    @Autowired
    public void setUserService(UserServiceIml userService) {
        this.userService = userService;
    }

    @Autowired
    public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Configuration
    public class MyCorsConfiguration {

        @Bean
        public CorsFilter corsFilter() {
            CorsConfiguration config = new CorsConfiguration();
            config.addAllowedOrigin("http://localhost:5173"); // Add your allowed origins here
            config.addAllowedMethod("*");
            config.addAllowedHeader("*");
            config.setAllowCredentials(true);

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);

            return new CorsFilter(source);
        }
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and() //disable()
//                не нуждается в авторизации
                .authorizeRequests()
                .antMatchers(
                        "/auth/registration",
                        "/auth/auth",

                        "/swagger-ui/",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-resources",
                        "/swagger-resources/*",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/webjars/**")
                .permitAll()

//                .antMatchers("/product/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/product/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/product/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/product/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/product/**").hasRole("ADMIN")

                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")

                .anyRequest()
                .authenticated()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
//                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

        return http.build();

    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
