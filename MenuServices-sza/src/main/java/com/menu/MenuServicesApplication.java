package com.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.menu")
public class MenuServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuServicesApplication.class, args);
	}
	@Bean
	public Sampler getSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
}
