package com.example.userclientfeign.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userclientfeign.entity.Menu;
import com.example.userclientfeign.entity.Tables;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("table-service")
public interface TableService {
	@Retry(name="table-service")
	@CircuitBreaker(name="table-service",fallbackMethod="fallbackMethodgetTableById")
	@GetMapping("tables/users/{userId}")
    public List<Tables> getRatingsByUserId(@PathVariable String userId);
	
	@Retry(name="table-service")
	@CircuitBreaker(name="table-service",fallbackMethod="fallbackMethodgetTables")
	 @GetMapping("/tables")
	    public List<Tables> getTables();
	
	
	//fallback methods
		public default List<Tables> fallbackMethodgetTableById(String id,Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			return new ArrayList<Tables>();
		}
		
		public default List<Tables>  fallbackMethodgetTables(Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			return new ArrayList<Tables>();
		}
		
}
