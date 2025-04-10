package com.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class CafecontactApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafecontactApplication.class, args);
	}
	@Bean
	public Sampler getSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
}
