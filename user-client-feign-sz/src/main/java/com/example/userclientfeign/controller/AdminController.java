package com.example.userclientfeign.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.userclientfeign.entity.Admin;
import com.example.userclientfeign.entity.Cafe;
import com.example.userclientfeign.entity.Menu;
import com.example.userclientfeign.entity.Tables;
import com.example.userclientfeign.entity.User;
import com.example.userclientfeign.proxy.AdminService;
import com.example.userclientfeign.proxy.CafeService;
import com.example.userclientfeign.proxy.MenuService;
import com.example.userclientfeign.proxy.TableService;
import com.example.userclientfeign.proxy.UserService;

@RestController
@Scope("request")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CafeService cafeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TableService tableService;
	
	@Autowired
	private MenuService menuService;
	
	private Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/get-users/{id}")
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
	@GetMapping("/get-users")
	public List<User> getAllUser()
	{
		List<User> userlist = userService.getAllUser();
		for (User user : userlist) {
	        List<Tables> tables = tableService.getRatingsByUserId(user.getUserId());
	        for (Tables table : tables) {
	            String menuId = table.getMenuId();
	            Menu menu = menuService.getMenu(menuId);
	            table.setMenu(menu);
	        }
	        user.setTables(tables);
	    }
		return userlist;
	}
	
	@GetMapping("/get-menus")
    public List<Menu> getAllMenus()
    {
		List<Menu> menulist = menuService.getAllMenus();
		return menulist;
    }
	
	@GetMapping("get-menus/{menu_id}")
    public Menu getMenu(@PathVariable String menu_id)
    {
		log.debug("in getMenukById with Id: "+menu_id);
		 Menu menu = menuService.getMenu(menu_id);
		 log.debug("in getMenuById with return value Book: "+menu);
		 return menu;
    }
	
	@GetMapping("/get-tables")
    public List<Tables> getTables()
    {
		List<Tables> tables = tableService.getTables();
		return tables;
    }
	
	 @GetMapping("/get-admins")
	    public List<Admin> getAllAdmins()
	    {
		 	List<Admin> admins = adminService.getAllAdmins();
		 	return admins;
	    }
	 @GetMapping("get-admin/{adminId}")
	    public Admin getAdminById(@PathVariable String adminId)
	    {
		 	Admin admin = adminService.getAdminById(adminId);
		 	return admin;
	    }
	 

	 @GetMapping("/get-contact")
	 public List<Cafe> getAllEntities()
	    {
		 	List<Cafe> cafeContact = cafeService.getAllEntities();
		 	return cafeContact;
	    }
}
