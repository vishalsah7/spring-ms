package com.jwtauth.jwt.config;

import com.jwtauth.jwt.security.JwtAuthEntrypoint;
import com.jwtauth.jwt.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthEntrypoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

    /**
     * HttpSecurity httpSecurity:
     * This parameter is injected by Spring and represents the configuration of web-based security.
     *
     * Disables CSRF protection. CSRF (Cross-Site Request Forgery) is a security feature that prevents unauthorized
     * commands being transmitted from a user that the web application trusts.
     *
     * Disables CORS (Cross-Origin Resource Sharing) configuration. CORS is a security feature that restricts how
     * resources on a web page can be requested from another domain.
     * When a server receives a cross-origin request from a browser, it responds with CORS headers that instruct the
     * browser on whether the request is allowed
     *
     * .anyRequest().authenticated() specifies that any request not matched by the previous rules must be authenticated.
     * This means all other requests require the user to be logged in
     *
     * adds a custom filter (referred to as filter) before the UsernamePasswordAuthenticationFilter in the filter chain.
     * This is typically done to add custom authentication or authorization logic.
     *
     * builds the HttpSecurity configuration and returns a SecurityFilterChain object,
     * which is then used by Spring Security to enforce the defined security rules
     *
     * Summary
     * Disabling CSRF: Suitable for stateless applications.
     * Disabling CORS: CORS is not handled by Spring Security in this configuration.
     * Authorization Rules: Defines specific roles required for certain URL patterns.
     * Permit All: Allows public access to the login endpoint.
     * Authenticated Requests: Requires authentication for all other requests.
     * Exception Handling: Customizes how authentication errors are handled.
     * Stateless Session Management: Suitable for APIs where each request is independent.
     * Custom Filter: Adds a custom filter for additional processing before the standard authentication filter.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //using lambda expressions for functional interfaces
        //todo: understand functional interfaces
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/**").hasRole("ADMIN")
                        .requestMatchers("/test/**").hasRole("TEST")
                        .requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
