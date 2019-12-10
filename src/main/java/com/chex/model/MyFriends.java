package com.chex.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyFriends {
	@Id
	@Column(name = "user_id")
	private Long user_id;
	@Column(name = "user_friends_id")
	private String userFriendsId;
	
	public MyFriends() {
	}

	public MyFriends(Long user_id, String userFriendsId) {
		this.user_id = user_id;
		this.userFriendsId = userFriendsId;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUserFriendsId() {
		return userFriendsId;
	}

	public void setUserFriendsId(String userFriendsId) {
		this.userFriendsId = userFriendsId;
	}

	@Override
	public String toString() {
		return "MyFriendsController [user_id=" + user_id + ", UserFriendsId=" + userFriendsId + "]";
	}
	
	public List<Long> toList(){
		List<Long> list = new ArrayList<>();
		if(userFriendsId == null)return list;
		String f_array[] = userFriendsId.split(":");
		
		for(String s : f_array) {
			list.add(Long.parseLong(s));
		}
		return list;		
	}
	
	public void addFriendId(Long friendId) {
		if(userFriendsId == null) {
			userFriendsId = Long.toString(friendId);
		}
		else {
			userFriendsId += ":" + Long.toString(friendId);
		}
		
	}
}
