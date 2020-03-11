package com.chex.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VisitedPlace {

	@Id
	@GeneratedValue
	private Long pk;
	private Long userid;
	private Long albumid;
	private String placename;
	private String placeid;
	private String description;
	private int likes;
	private Date visitedDate;
	
	public VisitedPlace() {
	}

	public VisitedPlace(Long pk, Long userid, Long albumid, String placename, String placeid, String description,
			int likes, Date visitedDate) {
		this.pk = pk;
		this.userid = userid;
		this.albumid = albumid;
		this.placename = placename;
		this.placeid = placeid;
		this.description = description;
		this.likes = likes;
		this.visitedDate = visitedDate;
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

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getPlaceid() {
		return placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Date getVisitedDate() {
		return visitedDate;
	}

	public void setVisitedDate(Date visitedDate) {
		this.visitedDate = visitedDate;
	}

	@Override
	public String toString() {
		return "VisitedPlace [pk=" + pk + ", userid=" + userid + ", albumid=" + albumid + ", placename=" + placename
				+ ", placeid=" + placeid + ", description=" + description + ", likes=" + likes + ", visitedDate="
				+ visitedDate + "]";
	}
}
