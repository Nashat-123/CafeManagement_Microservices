package com.example.userclientfeign.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userclientfeign.entity.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("user-service")
public interface UserService {
	@Retry(name="user-service")
	@CircuitBreaker(name="user-service",fallbackMethod="fallbackMethodgetUserById")
	 @GetMapping("users/{userId}")
	 public User getSingleUser(@PathVariable String userId);
	 
	@Retry(name="user-service")
	@CircuitBreaker(name="table-service",fallbackMethod="fallbackMethodgetUsers")
	 @GetMapping("/users")
	    public List<User> getAllUser();
	//fallback methods
	public default User fallbackMethodgetUserById(String id,Throwable cause)
	{

		System.out.println("Exception raised with message:===>"+cause.getMessage());
		return new User(id, "fallback name", "fallback user", "fallback about", null);
	}
	public default List<User> fallbackMethodgetUsers(Throwable cause)
	{
		System.out.println("Exception raised with message:===>"+cause.getMessage());
		return new ArrayList<User>();
	}
}
