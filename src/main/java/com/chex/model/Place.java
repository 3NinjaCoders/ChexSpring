package com.chex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {

	@Id
	@GeneratedValue
	private Long id;
	private String placeid;
	private String name;
	private double x;
	private double y;
	private String photo_url;
	private String description;
	private int numvote;
	private int numpositive;
	private int points;
	private String category;
	
	public Place() {
	}

	public Place( String placeid, String name, double x, double y, String photo_url, String description,
			int numvote, int numpositive, int points, String category) {
		this.placeid = placeid;
		this.name = name;
		this.x = x;
		this.y = y;
		this.photo_url = photo_url;
		this.description = description;
		this.numvote = numvote;
		this.numpositive = numpositive;
		this.points = points;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaceid() {
		return placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumvote() {
		return numvote;
	}

	public void setNumvote(int numvote) {
		this.numvote = numvote;
	}

	public int getNumpositive() {
		return numpositive;
	}

	public void setNumpositive(int numpositive) {
		this.numpositive = numpositive;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", placeid=" + placeid + ", name=" + name + ", x=" + x + ", y=" + y + ", photo_url="
				+ photo_url + ", description=" + description + ", numvote=" + numvote + ", numpositive=" + numpositive
				+ ", points=" + points + ", category=" + category + "]";
	}
}
