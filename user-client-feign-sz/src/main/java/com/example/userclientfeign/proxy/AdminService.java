package com.example.userclientfeign.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userclientfeign.entity.Admin;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@FeignClient("admin-service")
public interface AdminService {
	
	 
		@Retry(name="admin-service")
		@CircuitBreaker(name="admin-service",fallbackMethod="fallbackMethodgetAdmins")
	 @GetMapping("admin/all")
	    public List<Admin> getAllAdmins();
	
		@Retry(name="admin-service")
		@CircuitBreaker(name="admin-service",fallbackMethod="fallbackMethodgetAdminById")
		@GetMapping("admin/{adminId}")
	    public Admin getAdminById(@PathVariable String adminId);
		
		
		public default List<Admin> fallbackMethodgetAdmins(Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			return new ArrayList<Admin>();
		}
		
		public default Admin fallbackMethodgetAdminById(String id,Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			return new Admin(id, "fallback","fallback", "fallback", "fallback", "fallback", "fallback");
		}
}
