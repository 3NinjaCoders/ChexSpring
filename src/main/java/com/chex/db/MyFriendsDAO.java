package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chex.model.MyFriends;

@Repository
public interface MyFriendsDAO extends JpaRepository<MyFriends, Long> {

	@Query(value = "select new java.lang.Boolean(count(*) > 0 ) from MyFriends where user_id=:user_id and userFriendsId=:userFriendsId")
	Boolean isMyFriend(@Param("user_id") Long user_id, @Param("userFriendsId") String friendId);
			
}
