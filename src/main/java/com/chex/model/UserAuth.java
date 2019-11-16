package com.chex.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAuth {
	
	@Id
	private String username;
	private String password;
	private long user_id;
	private String role;
	private int active;
	
	public UserAuth() {
	}
	public UserAuth(long user_id, String username, String password, String role) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = 1;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
