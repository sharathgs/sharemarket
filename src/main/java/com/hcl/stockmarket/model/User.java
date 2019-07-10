package com.hcl.stockmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccounts")
public class User {
	
	@Id
	@GeneratedValue
	private int user_id;
	private String username;
	private String address;
	private int age;
	private String emailid;
	private String password;
	private Double pendingamount;
	
	
	
	
	public User() {
		super();
	}
	public User(int user_id, String username, String address, int age, String emailid, String password,
			Double pendingamount) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.address = address;
		this.age = age;
		this.emailid = emailid;
		this.password = password;
		this.pendingamount = pendingamount;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getPendingamount() {
		return pendingamount;
	}
	public void setPendingamount(Double pendingamount) {
		this.pendingamount = pendingamount;
	}
	

}
