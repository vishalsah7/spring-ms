package com.jwtauth.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    public AppConfig() {
        System.out.println("constructin, constructor added for debugging only");
    }

    //ideally we could have connected to a db to check if user credentials is valid or not. but here we use in memory UserDetails
    //todo: fetch this from a db
    //notice we did not call the userDetailService() anywhere, yet when authentication request comes,
    // as this method is annotated with @Bean, spring uses this method as a provider for UserDetailsService.
    // this also means somewhere some library code is looking for a UserDetailsService and spring ensures that they use our impl of UserDetailsService

    //if you create another bean annotated method that has a return type of userDetailsService
    // (e.g. see the commented code for userDetailsService2), you would see an error in console like
    // Found 2 UserDetailsService beans, with names [userDetailService2, userDetailService]. Global Authentication Manager will not use a UserDetailsService for username/password login. Consider publishing a single UserDetailsService bean.
    @Bean
    public UserDetailsService userDetailService() {
        UserDetails user1 = User.builder().username("vishal").password(passwordEncoder().encode("sah")).roles("ADMIN").build();
        UserDetails user2 = User.builder().username("trisha").password(passwordEncoder().encode("sah")).roles("USER").build();
        UserDetails user3 = User.builder().username("kajal").password(passwordEncoder().encode("sah")).roles("TEST").build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    /*@Bean
    public UserDetailsService userDetailService2() {
        UserDetails user1 = User.builder().username("vishal").password(passwordEncoder().encode("sah1")).roles("ADMIN").build();
        UserDetails user2 = User.builder().username("trisha").password(passwordEncoder().encode("sah1")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }*/


    //spring expects provider of PassowrdEncoder service to be managed by Spring IOC, ie. it should be annotated with @Bean
    //if you do not annotate passwordEncoder with @bean, Spring will not use this method as the default provider for PasswordEncoder Service.
    //If not annotated, this might have no significance on using this method inside this class

    //If you annotate this method with @Bean it has implications outside of this class i.e. any class/library expecting
    // a PasswordEncoder service will use our impl of Password encoder or else the libraries/global configs managed by
    // Spring will use some other PasswordEncoder and not this one.

    //annotating with @Bean we ensure that Spring ioc uses our version of PasswordEncoder whereever a PasswordEncoder is
    // needed be it in our class or some library managed by ioc context
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
