package com.contact.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;


import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contact")
public class Cafe {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String address;
    private String phoneNumber;
    private String timeToContact;
	public Cafe(Long id, String email, String address, String phoneNumber, String timeToContact) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.timeToContact = timeToContact;
	}
	public Cafe() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTimeToContact() {
		return timeToContact;
	}
	public void setTimeToContact(String timeToContact) {
		this.timeToContact = timeToContact;
	}
	@Override
	public String toString() {
		return "Cafe [id=" + id + ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", timeToContact=" + timeToContact + "]";
	}
    
}
