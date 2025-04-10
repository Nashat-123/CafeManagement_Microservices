package com.table.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.table.entites.Tables;
import com.table.services.TableServices;
@RestController
@RequestMapping("/tables")
public class TableController {
	
	
	@Autowired
	private TableServices tableservices;
	
	 @PostMapping
	    public ResponseEntity<Tables> create(@RequestBody Tables tables) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(tableservices.create(tables));
	    }

	    //get all
	    @GetMapping
	    public ResponseEntity<List<Tables>> getTables() {
	        return ResponseEntity.ok(tableservices.getTables());
	    }

	    //get all of user
	    
	    @GetMapping("/users/{userId}")
	    public ResponseEntity<List<Tables>> getRatingsByUserId(@PathVariable String userId) {
	        return ResponseEntity.ok(tableservices.GetOrderByUSerID(userId));
	    }

	    //get all of hotels
	    @GetMapping("/menus/{menu_id}")
	    public ResponseEntity<List<Tables>> getOrederBYMEnuId(@PathVariable String menu_id) {
	        return ResponseEntity.ok(tableservices.GetOrderByMenu(menu_id));
	    }
	    @DeleteMapping("/{tableId}")
	    public ResponseEntity<Void> deleteTableById(@PathVariable String tableId) {
	        tableservices.deleteTableById(tableId);
	        return ResponseEntity.noContent().build();
	    }


}
