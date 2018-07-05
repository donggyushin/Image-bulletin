package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	long id;
	
	@Column(nullable=false, unique=true, length=20)
	private String userId;
	@Column(nullable = false, length = 20)
	private String userName;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false, unique = true, length = 70)
	private String email;
	
	public User() {
		
	}
	
	public User(String userId, String userName, String password, String email) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(nullable=false, unique=true, length=20)
	public String getUserId() {
		return userId;
	}
	@Column(nullable=false, unique=true, length=20)
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + "]";
	}
	
	
	
	

}
