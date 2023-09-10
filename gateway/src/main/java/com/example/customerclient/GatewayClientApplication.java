package com.example.customerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayClientApplication.class, args);
	}



	// api:8081
	// static-react-angular-vue-nginx:8020
	@Bean
	RouteLocator gateway(RouteLocatorBuilder rlb) {
		var apiPrefix = "/api/";
		return rlb
				.routes()
				.route(rs -> rs
						.path(apiPrefix + "**")
						.filters(f -> f
								.tokenRelay()
								.rewritePath(apiPrefix + "(?<segment>.*)", "/$\\{segment}")
						)
						.uri("http://localhost:8081"))
				.route(rs -> rs
						.path("/**")
						.uri("http://localhost:8020")// cdn for static assets
				)
				.build();
	}
}

