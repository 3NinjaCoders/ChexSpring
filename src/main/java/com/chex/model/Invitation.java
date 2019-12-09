package com.chex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invitation")
public class Invitation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pk;
	@Column(name = "user_id")
	private Long userId;
	private Long inviters;
	
	public Invitation() {
	}

	public Invitation(Long pk, Long user_id, Long inviters) {
		this.pk = pk;
		this.userId = user_id;
		this.inviters = inviters;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Long getUser_id() {
		return userId;
	}

	public void setUser_id(Long user_id) {
		this.userId = user_id;
	}

	public Long getInviters() {
		return inviters;
	}

	public void setInviters(Long inviters) {
		this.inviters = inviters;
	}

	@Override
	public String toString() {
		return "Invitation [pk=" + pk + ", user_id=" + userId + ", inviters=" + inviters + "]";
	}
}
