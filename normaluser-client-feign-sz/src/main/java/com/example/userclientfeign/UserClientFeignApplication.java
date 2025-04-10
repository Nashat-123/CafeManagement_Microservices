package com.example.userclientfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@EnableFeignClients
@SpringBootApplication
public class UserClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserClientFeignApplication.class, args);
	}
	@Bean
	public Sampler getSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}

}
