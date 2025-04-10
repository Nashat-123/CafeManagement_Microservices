package com.adminservice.proxy;

import java.util.ArrayList;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adminservice.dto.Menu;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("menu-service")
public interface MenuService {
	
	@Retry(name="menu-service")
	@CircuitBreaker(name="menu-service",fallbackMethod="fallbackMethodgetMenuById")
	 @GetMapping("menus/{menu_id}")
	    public Menu getMenu(@PathVariable String menu_id);
	 
	@Retry(name="menu-service")
	@CircuitBreaker(name="menu-service",fallbackMethod="fallbackMethodgetMenus")
	 @GetMapping("/menus")
	    public List<Menu> getAllMenus();
	
	
	//fallback methods
	public default List<Menu> fallbackMethodgetMenus(Throwable cause)
	{
		System.out.println("Exception raised with message:===>"+cause.getMessage());
		
		List<Menu> dummyMenus = new ArrayList<>();

	    Menu menu1 = new Menu("1", "Fallback Menu 1", "10.00", "Fallback Description 1", "Available");
	    Menu menu2 = new Menu("2", "Fallback Menu 2", "15.00", "Fallback Description 2", "Available");

	    dummyMenus.add(menu1);
	    dummyMenus.add(menu2);

	    return dummyMenus;
	}
	
	public default Menu fallbackMethodgetMenuById(String id,Throwable cause)
	{
		System.out.println("Exception raised with message:===>"+cause.getMessage());
		return new Menu(id,"fallback name", "fallback price", "fallback description", "status");
	}
}
