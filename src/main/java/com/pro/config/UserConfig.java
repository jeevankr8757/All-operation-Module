package com.pro.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfig {
	
	// This is the default behavior of the spring security
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
		
		http.csrf(csrfConfig -> csrfConfig.disable())
		          .authorizeHttpRequests((requests) -> requests
				                                 .requestMatchers("/imageUpload" , "/dashboard" , "/history").authenticated()
				                                 .requestMatchers(HttpMethod.GET ,"/welcome").hasRole("USER")
				                                 .requestMatchers(HttpMethod.PUT ,"/updateuser/{userId}").hasRole("ADMIN")
				                                 . requestMatchers("/login"  ,"/users", "/create/**" , "/test", "/user/{id}","/updateuser/{userId}", "/users", "/getUser/**", "/public/**").permitAll() );


//		http.formLogin(flc -> flc.disable());
//		http.httpBasic(hbc -> hbc.disable());
		
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		
		return http.build();
	}
	
	// 1. This is the inMemoryAuthentication 
	// In this case taking the username and password from the memeory and authentication is performed
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("user").password("{noop}123").authorities("read").build();
//		UserDetails admin = User.withUsername("admin").password("{noop}321").authorities("admi").build();
//		
//		return new InMemoryUserDetailsManager(user , admin);
//	}
	
	
	// 2. This is the jdbcUserDetailsManager Authentication
	// In this case taking the username and password from the database
//	@Bean
//	public UserDetailsService userDetailsService(DataSource datasource) {
//		return new JdbcUserDetailsManager(datasource);
//	}
	

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}