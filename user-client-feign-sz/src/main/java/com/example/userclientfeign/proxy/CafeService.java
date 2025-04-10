package com.example.userclientfeign.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.userclientfeign.entity.Cafe;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@FeignClient("cafe-service")
public interface CafeService {
	
	@Retry(name="cafe-service")
	@CircuitBreaker(name="cafe-service",fallbackMethod="fallbackMethodgetCafeContact")
	@GetMapping("/api/cafes")
    public List<Cafe> getAllEntities();
	
	public default List<Cafe> fallbackMethodgetCafeContact(Throwable cause)
	{
		System.out.println("Exception raised with message:===>"+cause.getMessage());
		return new ArrayList<Cafe>();
	}
}
