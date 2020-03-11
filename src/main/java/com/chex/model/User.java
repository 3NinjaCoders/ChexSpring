package com.chex.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
	
	@Id
	private long userid;
	private String firstname;
	private String lastname;
	private String publicname;
	private int sex;
	private Date dateofregistration;
	private Date dateofbirth;
	private String profilphoto;
	private String city;
	private String country;
	private int ulevel;
	private int exp;
	
	
	public User() {
	}

	public User(long userid, String firstname, String lastname, String publicname, int sex, Date dateofregistration,
			Date dateofbirth, String profilphoto, String city, String country, int ulevel, int exp) {
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.publicname = publicname;
		this.sex = sex;
		this.dateofregistration = dateofregistration;
		this.dateofbirth = dateofbirth;
		this.profilphoto = profilphoto;
		this.city = city;
		this.country = country;
		this.ulevel = ulevel;
		this.exp = exp;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPublicname() {
		return publicname;
	}

	public void setPublicname(String publicname) {
		this.publicname = publicname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(Date dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getProfilphoto() {
		return profilphoto;
	}

	public void setProfilphoto(String profilphoto) {
		this.profilphoto = profilphoto;
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
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", publicname="
				+ publicname + ", sex=" + sex + ", dateofregistration=" + dateofregistration + ", dateofbirth="
				+ dateofbirth + ", profilphoto=" + profilphoto + ", city=" + city + ", country=" + country + ", ulevel="
				+ ulevel + ", exp=" + exp + "]";
	}

}
