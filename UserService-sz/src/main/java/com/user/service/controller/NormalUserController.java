package com.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dto.Cafe;
import com.user.service.dto.Menu;
import com.user.service.dto.Tables;
import com.user.service.dto.User;
import com.user.service.proxy.CafeService;
import com.user.service.proxy.MenuService;
import com.user.service.proxy.TableService;
import com.user.service.proxy.UserService;



@RestController
@Scope("request")
public class NormalUserController {
	
	@Autowired
	private CafeService cafeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TableService tableService;
	
	@Autowired
	private MenuService menuService;
	
	private Logger log = LoggerFactory.getLogger(NormalUserController.class);
	
	@GetMapping("/getUsers/{id}")
	 public User getSingleUser(@PathVariable String id)
	 {	
		List<Tables> tables = tableService.getRatingsByUserId(id);
		User user = userService.getSingleUser(id);
		 for (Tables table : tables) {
		        String menuId = table.getMenuId();
		        Menu menu = menuService.getMenu(menuId);
		        table.setMenu(menu);
		        
		    }
		user.setTables(tables);
		 return user;
	 }
	
	
	@GetMapping("/getMenus")
    public List<Menu> getAllMenus()
    {
		List<Menu> menulist = menuService.getAllMenus();
		return menulist;
    }
	
	@GetMapping("getMenus/{menu_id}")
    public Menu getMenu(@PathVariable String menu_id)
    {
		log.debug("in getMenukById with Id: "+menu_id);
		 Menu menu = menuService.getMenu(menu_id);
		 log.debug("in getMenuById with return value Book: "+menu);
		 return menu;
    }
	
	@GetMapping("/getContact")
	 public List<Cafe> getAllEntities()
	    {
		 	List<Cafe> cafeContact = cafeService.getAllEntities();
		 	return cafeContact;
	    }
	@GetMapping("getContact/{id}")
    public Cafe getEntityById(@PathVariable Long id)
    {
	 	Cafe cafe = cafeService.getEntityById(id);
	 	return cafe;
    }
}
