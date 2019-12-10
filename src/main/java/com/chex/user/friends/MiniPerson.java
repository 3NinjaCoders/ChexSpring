package com.chex.user.friends;

import com.chex.enums.PersonStatus;

public class MiniPerson {
	
	private Long user_id;
	private String public_name;
	private String photo;
	private String personStatus;
	
	public MiniPerson() {
	}
	
	public MiniPerson(Long user_id, String public_name, String photo, String personStatus) {
		this.user_id = user_id;
		this.public_name = public_name;
		this.photo = photo;
		this.personStatus = personStatus;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getPublic_name() {
		return public_name;
	}
	public void setPublic_name(String public_name) {
		this.public_name = public_name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPersonStatus() {
		return personStatus;
	}
	public void setPersonStatus(String personStatus) {
		this.personStatus = personStatus;
	}
	
	@Override
	public String toString() {
		return "MiniPerson [user_id=" + user_id + ", public_name=" + public_name + ", photo=" + photo
				+ ", personStatus=" + personStatus + "]";
	}
}
