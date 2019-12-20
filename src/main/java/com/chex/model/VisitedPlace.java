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
	private Long userId;
	private Long albumId;
	private Long placeId;
	private String description;
	private int likes;
	private Date visitedDate;
	
	public VisitedPlace() {
	}

	public VisitedPlace(Long pk, Long userId, Long albumId, Long placeId, String description, int likes,
			Date visitedDate) {
		this.pk = pk;
		this.userId = userId;
		this.albumId = albumId;
		this.placeId = placeId;
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

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
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
		return "VisitedPlace [pk=" + pk + ", userId=" + userId + ", albumId=" + albumId + ", placeId=" + placeId
				+ ", description=" + description + ", likes=" + likes + ", visitedDate=" + visitedDate + "]";
	}
}
