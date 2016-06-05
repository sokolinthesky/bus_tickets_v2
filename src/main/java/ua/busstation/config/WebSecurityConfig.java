package ua.busstation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.busstation.security.CustomUserDetailsService;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService);/*.passwordEncoder(passwordencoder());*/
 } 
 

 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
  .antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/users").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/hello").access("hasRole('ROLE_USER')")
  .antMatchers("/index").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/index").access("hasRole('ROLE_USER')")
  .antMatchers("/index/chooseBus").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/index/chooseBus").access("hasRole('ROLE_USER')")
  .antMatchers("/index/reckoning").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/index/reckoning").access("hasRole('ROLE_USER')")
  .anyRequest().permitAll()
  .and()
    .formLogin().loginPage("/login")
    .usernameParameter("username").passwordParameter("password")
  .and()
    .logout().logoutSuccessUrl("/index")
           .and()
           .exceptionHandling().accessDeniedPage("/403")
  .and()
    .csrf();
 }
 
 /*@Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }*/
}