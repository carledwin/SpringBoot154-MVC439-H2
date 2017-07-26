package com.tarefa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationProviderService authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/")
					.permitAll()
				.antMatchers("/tarefa","/console","/console/**")
					.permitAll()
				.antMatchers("/h2/**")
					.permitAll()
				.antMatchers("/dashboard")
					.hasRole("DASHBOARD")
				.antMatchers("/")
					.permitAll()
				.antMatchers("/usuario")
					.hasRole("USUARIO")
				.anyRequest()
					.authenticated()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/negado")
			.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("login")
				.passwordParameter("senha")
				.failureUrl("/login?error=1")
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.invalidateHttpSession(true)
				.permitAll();
				
		
				http.csrf().disable();
				http.authorizeRequests().anyRequest().fullyAuthenticated();
				http.headers().frameOptions().disable();
	}
}
