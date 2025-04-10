package com.example.userclientfeign.entity;

import java.util.ArrayList;

import java.util.List;

public class User {
	
	private String userId;
	
	private String name;
	
	private String email;
	
	private String about;
	
	
    private List<Tables> tables=new ArrayList<>();


	public User(String userId, String name, String email, String about, List<Tables> tables) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.tables = tables;
	}


	public User() {
		super();
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public List<Tables> getTables() {
		return tables;
	}


	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", about=" + about + ", tables="
				+ tables + "]";
	}
    
}
