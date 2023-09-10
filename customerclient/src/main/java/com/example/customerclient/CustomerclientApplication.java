package com.example.customerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@SpringBootApplication
public class CustomerclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerclientApplication.class, args);
	}


}

@RestController
class CustomerController {
	@GetMapping("/hello")
	Map<String, String> hello(Principal principal) {
		return Map.of("message", "hello " + principal.getName());
	}
}