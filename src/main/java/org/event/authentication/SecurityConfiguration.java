package org.event.authentication;

import org.event.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	
	  @Override protected void configure(HttpSecurity http) throws Exception {
		  http.cors();
	  http.csrf().disable().authorizeRequests() .antMatchers("/authenticate").permitAll()
	  .antMatchers("/members/allM").hasAuthority("admin")
	  .antMatchers("/users/**").permitAll()
	  .antMatchers("/members/allG").permitAll()
	  //.antMatchers("/members/allM").hasAuthority("admin")
	  .anyRequest().authenticated()
	  .and()
	  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	 
	 
	  
	  }
	 
	 @Override
	 @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
