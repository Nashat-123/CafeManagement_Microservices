package com.user.service.Services;

import java.util.List;

import com.user.service.entities.User;

public interface UserServices {
	
	
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getSer(String UserId);
	
	void deleteUser(String UserId); 

    User updateUser(User user);

}
