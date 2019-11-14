package com.chex.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chex.model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, String> {
	UserAuth findByUsername(String username);
}
