package com.menu.entites;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menu_services")
public class Menu {
	
	 @Id
    private String menuId;
	
	
	private String name;
	

	private String itemPrice;
	
	
	private String description;
    

	private String status;


	public Menu(String menuId, String name, String itemPrice, String description, String status) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.itemPrice = itemPrice;
		this.description = description;
		this.status = status;
	}


	public Menu() {
		super();
	}


	public String getMenuId() {
		return menuId;
	}


	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", name=" + name + ", itemPrice=" + itemPrice + ", description=" + description
				+ ", status=" + status + "]";
	}
	
	
	
}
