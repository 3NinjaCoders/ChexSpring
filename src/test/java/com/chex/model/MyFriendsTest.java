package com.chex.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyFriendsTest {

	private MyFriends myfriendsEmpty;
	private MyFriends myfriendsOne;
	private MyFriends myfriendsTwo;
	private MyFriends myfriendsThree;
	@BeforeEach
	private void SetUp() {
		myfriendsEmpty = new MyFriends();
		myfriendsOne = new MyFriends(1l, "25");
		myfriendsTwo = new MyFriends(1l, "25:80");
		myfriendsThree = new MyFriends(1l, "25:80:458");
		
	}
	
	@Test
	void if_has_not_any_friend_return_empty_list() {
		List<Long> list = myfriendsEmpty.toList();
		assertNotNull(list);
		assertTrue(list.isEmpty());
	}
	
	@Test
	void if_has_not_one_friend_return_friend_id() {
		List<Long> list = myfriendsOne.toList();
		assertEquals(25, list.get(0));
	}
	
	@Test
	void if_has_two_friends_return_friends_id() {
		List<Long> list = myfriendsTwo.toList();
		assertEquals(25, list.get(0));
		assertEquals(80, list.get(1));
	}
	
	@Test
	void if_has_tree_friends_return_friends_id() {
		List<Long> list = myfriendsThree.toList();
		assertEquals(25, list.get(0));
		assertEquals(80, list.get(1));
		assertEquals(458, list.get(2));
	}
	
	@Test
	void if_has_not_any_friends_add_first_and_get() {
		assertNull(myfriendsEmpty.getUserFriendsId());
		myfriendsEmpty.addFriendId(34l);
		assertNotNull(myfriendsEmpty.getUserFriendsId());
		List<Long> list = myfriendsEmpty.toList();
		assertEquals(34l, list.get(0));
	}
	
	@Test
	void if_has_one_friend_should_add_another() {
		assertNotNull(myfriendsOne.getUserFriendsId());
		myfriendsOne.addFriendId(34l);
		
		List<Long> list = myfriendsOne.toList();
		assertEquals(25, list.get(0));
		assertEquals(34l, list.get(1));
	}

}
