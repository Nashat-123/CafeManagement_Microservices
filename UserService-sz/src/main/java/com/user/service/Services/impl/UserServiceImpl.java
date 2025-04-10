package com.user.service.Services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.Services.UserServices;
import com.user.service.entities.User;
import com.user.service.repository.UserRepository;
import com.user.service.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getSer(String UserId) {
		return userRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void deleteUser(String UserId) {
		userRepository.deleteById(UserId);
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	
	

}
