package com.chex.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chex.model.MyFriends;

public interface MyFriendsDAO extends JpaRepository<MyFriends, Long> {

}
