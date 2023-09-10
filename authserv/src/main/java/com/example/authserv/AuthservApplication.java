package com.example.authserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class AuthservApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthservApplication.class, args);
	}

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		var two = User.withDefaultPasswordEncoder().roles("user").username("mgray").password("pw").build() ;
		return new InMemoryUserDetailsManager(two);
	}
}
