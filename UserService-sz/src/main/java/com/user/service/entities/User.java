package com.user.service.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
	
	
	@Id
	private String userId;
	@Column(name="Name" , length= 20)
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="About")
	private String about;
	
	@Transient
    private List<Tables> tables=new ArrayList<>();

	public User(String userId, String name, String email, String about, List<Tables> tables) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.tables = tables;
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

	public User() {
		super();
	}

}
