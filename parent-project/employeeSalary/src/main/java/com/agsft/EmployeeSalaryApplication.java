package com.agsft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeeSalaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSalaryApplication.class, args);
	}

	@GetMapping("/newSalary")
	public ResponseEntity<String> getSalary(){
		return new ResponseEntity<>("This is new Salary", HttpStatus.OK);
	}
}
