package com.chex.model.admin.newplace;

public class PlaceData {
	private String place;
	private String new_place;
	private String id_place;
	
	public PlaceData() {
	}

	public PlaceData(String place, String new_place, String id_place) {
		this.place = place;
		this.new_place = new_place;
		this.id_place = id_place;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNew_place() {
		return new_place;
	}

	public void setNew_place(String new_place) {
		this.new_place = new_place;
	}

	public String getId_place() {
		return id_place;
	}

	public void setId_place(String id_place) {
		this.id_place = id_place;
	}

	@Override
	public String toString() {
		return "PlaceData [place=" + place + ", new_place=" + new_place + ", id_place=" + id_place + "]";
	}
}
