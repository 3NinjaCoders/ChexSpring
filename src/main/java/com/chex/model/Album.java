package com.chex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long pk;
	private Long userid;
	private Long albumid;
	private String photoPath;
	
	public Album() {
	}
	public Album(Long pk, Long userid, Long albumid, String photoPath) {
		this.pk = pk;
		this.userid = userid;
		this.albumid = albumid;
		this.photoPath = photoPath;
	}
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getAlbumid() {
		return albumid;
	}
	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	@Override
	public String toString() {
		return "Album [pk=" + pk + ", userid=" + userid + ", albumid=" + albumid + ", photoPath=" + photoPath + "]";
	}
}
