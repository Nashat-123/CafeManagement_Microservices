package com.example.usereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class UserEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserEurekaServerApplication.class, args);
	}

}
