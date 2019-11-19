package com.chex.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chex.model.User;

public interface UserDAO extends JpaRepository<User, Long>{

}
