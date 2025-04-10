package com.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservice.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, String> {
	   

		Admin findByUsername(String username);
	}
