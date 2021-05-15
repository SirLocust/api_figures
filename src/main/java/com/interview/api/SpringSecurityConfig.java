package com.interview.api;

import java.util.Arrays;
import java.util.Collections;

import com.interview.api.auth.JWTAuthenticationFilter;
import com.interview.api.auth.JWTAuthorizationFIlter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// @EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

    PasswordEncoder encoder = passwordEncoder();
    UserBuilder users = User.builder().passwordEncoder(encoder::encode);

    builder.inMemoryAuthentication().withUser(users.username("superadmin").password("bingola22").roles("ADMIN"));

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().authorizeRequests().anyRequest().authenticated().and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFIlter(authenticationManager())).csrf().disable().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

  }

  // @Bean
  // public CorsFilter corsFilter() {
  // UrlBasedCorsConfigurationSource source = new
  // UrlBasedCorsConfigurationSource();
  // CorsConfiguration corsConfiguration = new CorsConfiguration();

  // corsConfiguration.setAllowCredentials(true);
  // corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
  // corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
  // corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
  // source.registerCorsConfiguration("/**", corsConfiguration);
  // return new CorsFilter(source);
  // }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE",
            "OPTIONS");
      }
    };
  }

}
