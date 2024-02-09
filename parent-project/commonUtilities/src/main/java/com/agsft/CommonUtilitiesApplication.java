package com.agsft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CommonUtilitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonUtilitiesApplication.class, args);
	}

	@GetMapping("/getUtils")
	public ResponseEntity<String> getCommonUtils(){
		return new ResponseEntity<>("This is common utils module", HttpStatus.OK);
	}
}
