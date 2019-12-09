package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chex.model.Invitation;

@Repository
public interface InvitationDAO extends JpaRepository<Invitation, Long> {

	List<Invitation> findByUserId(Long user_id);
}
