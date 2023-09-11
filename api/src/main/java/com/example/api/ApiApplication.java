package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}

@RestController
class CustomerRestController {

	@GetMapping ("/me")
	Map <String, String> me (Principal p) {
		return Map.of("name" ,p.getName());
	}

	@GetMapping ("/customers")
	List<Customer> customers () {
		return  List.of(new Customer(1, "Mario") , new Customer(2 ,"Peanut"));
	}
}

record Customer (Integer id, String name) { }