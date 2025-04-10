package com.menu.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.menu.entites.Menu;


@Service
public interface Menuservices {
	Menu create(Menu menu);

    //get all
    List<Menu> getAll();

    //get single
    Menu get(String id);
   
    Menu update(Menu menu);

    // Delete
    void delete(String id);
}
