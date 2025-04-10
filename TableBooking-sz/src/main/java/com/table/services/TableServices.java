package com.table.services;

import com.table.entites.Tables;

import org.springframework.stereotype.Service;

import java.util.List;

public interface TableServices {
	
	
	Tables create(Tables table);


	    //get all ratings
	    List<Tables> getTables();

	  
	    List<Tables> GetOrderByUSerID(String userId);

	    
	    List<Tables> GetOrderByMenu(String menu_id);
	    
	    void deleteTableById(String tableId);

}
