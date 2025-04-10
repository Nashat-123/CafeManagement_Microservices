package com.adminservice.proxy;

import java.util.ArrayList;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adminservice.dto.Cafe;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("cafe-service")
public interface CafeService {
	
	@Retry(name="cafe-service")
	@CircuitBreaker(name="cafe-service",fallbackMethod="fallbackMethodgetCafeContact")
	@GetMapping("/api/cafes")
    public List<Cafe> getAllEntities();
	
	@Retry(name="cafe-service")
	@CircuitBreaker(name="cafe-service",fallbackMethod="fallbackMethodgetCafeContactById")
	 @GetMapping("/api/cafes/{id}")
	    public Cafe getEntityById(@PathVariable Long id) ;
	
	public default List<Cafe> fallbackMethodgetCafeContact(Throwable cause)
	{
		System.out.println("Exception raised with message:===>"+cause.getMessage());
		//return new ArrayList<Cafe>();
		List<Cafe> dummyCafes = new ArrayList<>();

	    Cafe cafe1 = new Cafe(1L, "fallback1@example.com", "Fallback Address 1", "1234567890", "8:00 AM - 5:00 PM");
	    Cafe cafe2 = new Cafe(2L, "fallback2@example.com", "Fallback Address 2", "0987654321", "9:00 AM - 6:00 PM");

	    dummyCafes.add(cafe1);
	    dummyCafes.add(cafe2);

	    return dummyCafes;
	}
	
	public default Cafe fallbackMethodgetCafeContactById(Long id,Throwable cause)
	{
		System.out.println("Exception raised with message:===>"+cause.getMessage());
		return new Cafe(id,"fallback name", "fallback price", "fallback description", "status");
	}
}
