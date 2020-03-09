package com.chex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="places")
public class Place {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String place_id;
	private String name;
	private double x;
	private double y;
	private String photo_url;
	private String description;
	private int num_vote;
	private int num_positive;
	private int points;
	private String category;
	
	public Place() {
	}

	public Place(String place_id, String name, double x, double y, String photo_url, String description, int num_vote,
			int num_positive, int points, String category) {
		this.place_id = place_id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.photo_url = photo_url;
		this.description = description;
		this.num_vote = num_vote;
		this.num_positive = num_positive;
		this.points = points;
		this.category = category;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
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

	public int getNum_vote() {
		return num_vote;
	}

	public void setNum_vote(int num_vote) {
		this.num_vote = num_vote;
	}

	public int getNum_positive() {
		return num_positive;
	}

	public void setNum_positive(int num_positive) {
		this.num_positive = num_positive;
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
		return "Place [place_id=" + place_id + ", name=" + name + ", x=" + x + ", y=" + y + ", photo_url=" + photo_url
				+ ", description=" + description + ", num_vote=" + num_vote + ", num_positive=" + num_positive
				+ ", points=" + points + ", category=" + category + "]";
	}
}
