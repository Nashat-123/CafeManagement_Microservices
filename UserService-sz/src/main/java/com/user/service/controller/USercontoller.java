package com.user.service.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.user.service.Services.UserServices;
import com.user.service.entities.User;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/users")
public class USercontoller {
	
	  @Autowired
	    private UserServices userService;
	  
	  private Logger logger = LoggerFactory.getLogger(USercontoller.class);
	  
	  @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User user1 = userService.saveUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	    }
        
	  
	  
	 /* @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
//    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Get Single User Handler: UserController");
//        logger.info("Retry count: {}", retryCount);

        User user = userService.getSer(userId);
        return ResponseEntity.ok(user);
    }*/
	  
	  @GetMapping("/{userId}")
	  public User getSingleUser(@PathVariable String userId)
	  {
		  User user = userService.getSer(userId);
		  return user;
	  }
	  
	  
	    @GetMapping
	    public ResponseEntity<List<User>> getAllUser() {
	        List<User> allUser = userService.getAllUser();
	        return ResponseEntity.ok(allUser);
	    }
	    @DeleteMapping("/{userId}")
	    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
	        userService.deleteUser(userId);
	        return ResponseEntity.noContent().build();
	    }
	    
	    @PutMapping("/{userId}")
	    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updatedUser) {
	        updatedUser.setUserId(userId); // Make sure the ID in the URL matches the ID in the request body
	        User user = userService.updateUser(updatedUser);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
