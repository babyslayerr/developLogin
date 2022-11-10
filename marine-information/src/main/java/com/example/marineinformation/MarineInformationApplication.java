package com.example.marineinformation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MarineInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarineInformationApplication.class, args);
	}

}
