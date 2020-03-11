package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chex.model.User;

public interface UserDAO extends JpaRepository<User, Long>{
	
	@Query(value = "FROM User where publicname like %:search%")
	List<User> findAllContainPublicName(@Param("search") String search);

}
