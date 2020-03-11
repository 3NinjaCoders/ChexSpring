package com.chex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAuth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String username;
	private String password;
	private String role;
	private int active;
	
	public UserAuth() {
	}
	public UserAuth(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = 1;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
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
	@Override
	public String toString() {
		return "UserAuth [userid=" + userid + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", active=" + active + "]";
	}
}
