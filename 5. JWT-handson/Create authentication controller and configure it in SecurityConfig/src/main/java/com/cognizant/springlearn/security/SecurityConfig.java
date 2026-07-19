package com.cognizant.springlearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

 @Bean
 public InMemoryUserDetailsManager users(){
   UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN").build();
   UserDetails user=User.builder().username("user").password(passwordEncoder().encode("pwd")).roles("USER").build();
   return new InMemoryUserDetailsManager(admin,user);
 }

 @Bean
 public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }

 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
   http.csrf(cs->cs.disable())
   .authorizeHttpRequests(auth->auth
      .requestMatchers("/countries").hasRole("USER")
      .requestMatchers("/authenticate").hasAnyRole("USER","ADMIN")
      .anyRequest().authenticated())
   .httpBasic(Customizer.withDefaults());
   return http.build();
 }
}
