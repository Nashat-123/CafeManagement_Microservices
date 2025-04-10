package com.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.*;
import com.menu.entites.Menu;
public interface MenuRepository extends JpaRepository<Menu, String> {

}
