package com.example.marineinformation;

import com.example.marineinformation.entities.MemberEntity;
import com.example.marineinformation.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
@RequiredArgsConstructor
public class MarineInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarineInformationApplication.class, args);
	}

}
