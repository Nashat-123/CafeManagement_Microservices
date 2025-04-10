package com.adminservice.proxy;

import java.util.ArrayList;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adminservice.dto.User;

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
		//return new ArrayList<User>();
		List<User> dummyUsers = new ArrayList<>();

	    // Create a dummy table for the user
	   // Tables dummyTable = new Tables("1", "userID1", "menuID1", null, 2, "Table No 2");

	    User user1 = new User("1", "Fallback User 1", "fallback1@example.com", "About Fallback User 1", null);
	    User user2 = new User("2", "Fallback User 2", "fallback2@example.com", "About Fallback User 2",null);

	    dummyUsers.add(user1);
	    dummyUsers.add(user2);

	    return dummyUsers;
	}
}
