package com.chex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long pk;
	private Long userId;
	private Long albumId;
	private String photoPath;
	
	public Album() {
	}
	public Album(Long pk, Long userId, Long albumId, String photoPath) {
		this.pk = pk;
		this.userId = userId;
		this.albumId = albumId;
		this.photoPath = photoPath;
	}
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	@Override
	public String toString() {
		return "Album [pk=" + pk + ", userId=" + userId + ", albumId=" + albumId + ", photoPath=" + photoPath + "]";
	}	
}
