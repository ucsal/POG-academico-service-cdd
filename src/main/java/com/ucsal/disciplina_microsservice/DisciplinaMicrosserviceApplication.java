package com.ucsal.disciplina_microsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DisciplinaMicrosserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisciplinaMicrosserviceApplication.class, args);
	}

}
