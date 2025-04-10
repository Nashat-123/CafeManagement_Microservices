package com.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@EnableDiscoveryClient
@SpringBootApplication
public class TableBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableBookingApplication.class, args);
	}
	@Bean
	public Sampler getSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
}
