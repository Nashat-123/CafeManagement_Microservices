package com.user.service.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.dto.Tables;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("table-service")
public interface TableService {
	@Retry(name="table-service")
	@CircuitBreaker(name="table-service",fallbackMethod="fallbackMethodgetTableById")
	@GetMapping("tables/users/{userId}")
    public List<Tables> getRatingsByUserId(@PathVariable String userId);
	
	@Retry(name="table-service")
	@CircuitBreaker(name="table-service",fallbackMethod="fallbackMethodgetTables")
	 @GetMapping("/tables")
	    public List<Tables> getTables();
	
	
	//fallback methods
		public default List<Tables> fallbackMethodgetTableById(String id,Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			//return new ArrayList<Tables>();
			List<Tables> dummyTables = new ArrayList<>();

		    Tables table1 = new Tables("1", "userID1", "menuID1", null, 2, "Table No 2");
		    Tables table2 = new Tables("2", "userID2", "menuID2", null, 4, "Table No 4");

		    dummyTables.add(table1);
		    dummyTables.add(table2);

		    return dummyTables;
		}
		
		public default List<Tables>  fallbackMethodgetTables(Throwable cause)
		{
			System.out.println("Exception raised with message:===>"+cause.getMessage());
			//return new ArrayList<Tables>();
			 List<Tables> dummyTables = new ArrayList<>();

			    Tables table1 = new Tables("1", "userID1", "menuID1", null, 2, "Table No 2");
			    Tables table2 = new Tables("2", "userID2", "menuID2", null, 4, "Table No 4");

			    dummyTables.add(table1);
			    dummyTables.add(table2);

			    return dummyTables;
		}
		
}
