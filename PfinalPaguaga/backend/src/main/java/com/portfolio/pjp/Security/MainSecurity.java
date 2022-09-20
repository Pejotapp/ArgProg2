
package com.portfolio.pjp.Security;

import com.portfolio.pjp.Security.JWT.JwtEntryPoint;
import com.portfolio.pjp.Security.JWT.JwtTokenFilter;
import com.portfolio.pjp.Security.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {
    
    @Autowired
    UserDetailsImpl userDetailsImpl;
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
    return new JwtTokenFilter();}
    
    @Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();}

   @Override
    protected void configure(HttpSecurity http) throws Exception{
    http.cors().and.csrf().disable().authorizeRequest().antMatchers("/auth/**").permitAll().anyRequest().authenticated}
}
