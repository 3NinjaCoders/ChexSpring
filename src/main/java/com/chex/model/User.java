package com.chex.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name = "user_id")
	private long userId;
	private String first_name;
	private String last_name;
	private String public_name;
	private int sex;
	private Date date_of_registration;
	private Date date_of_birth;
	private String profil_photo;
	private String city;
	private String country;
	private int ulevel;
	private int exp;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long user_id) {
		this.userId = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPublic_name() {
		return public_name;
	}
	public void setPublic_name(String public_name) {
		this.public_name = public_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getDate_of_registration() {
		return date_of_registration;
	}
	public void setDate_of_registration(Date date_of_registration) {
		this.date_of_registration = date_of_registration;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getProfil_photo() {
		return profil_photo;
	}
	public void setProfil_photo(String profil_photo) {
		this.profil_photo = profil_photo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getUlevel() {
		return ulevel;
	}
	public void setUlevel(int ulevel) {
		this.ulevel = ulevel;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "User [user_id=" + userId + ", first_name=" + first_name + ", last_name=" + last_name + ", public_name="
				+ public_name + ", sex=" + sex + ", date_of_registration=" + date_of_registration + ", date_of_birth="
				+ date_of_birth + ", profil_photo=" + profil_photo + ", city=" + city + ", country=" + country
				+ ", ulevel=" + ulevel + ", exp=" + exp + "]";
	}
	
	
}
