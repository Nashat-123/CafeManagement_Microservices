package com.user.service.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.dto.Admin;

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
			
			//eturn new ArrayList<Admin>();
			List<Admin> dummyAdmins = new ArrayList<>();

		    Admin admin1 = new Admin("1", "Fallback Admin 1", "fallback1@example.com", "1234567890", "Fallback Address 1", "fallback1", "fallbackPassword1");
		    Admin admin2 = new Admin("2", "Fallback Admin 2", "fallback2@example.com", "0987654321", "Fallback Address 2", "fallback2", "fallbackPassword2");

		    dummyAdmins.add(admin1);
		    dummyAdmins.add(admin2);

		    return dummyAdmins;
		}
		
		public default Admin fallbackMethodgetAdminById(String id,Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			return new Admin(id, "fallback","fallback", "fallback", "fallback", "fallback", "fallback");
		}
}
