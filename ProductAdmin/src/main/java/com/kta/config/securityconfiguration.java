package com.kta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kta.service.MyUserDetailsService;

@EnableWebSecurity
public class securityconfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService myuserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(myuserDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		//.antMatchers("/resources/**").permitAll()
	      	.anyRequest().authenticated()
        	.and()
        	.formLogin().loginPage("/login").permitAll().and()
            .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/login");

            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));   
//            .logout()
//    		.invalidateHttpSession(true).clearAuthentication(true).deleteCookies("remember-me")  //when user logout delete every cookie and session
//    		.logoutUrl("/logout")
 //           .permitAll();
//    		.and().headers().frameOptions().sameOrigin();   //to prevent clickjacking attack
    		
            
        	
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
