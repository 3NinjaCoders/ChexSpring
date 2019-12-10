package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chex.model.Invitation;

@Repository
public interface InvitationDAO extends JpaRepository<Invitation, Long> {

	List<Invitation> findByUserId(Long user_id);
	
	@Query(value = "select new java.lang.Boolean(count(*) > 0 ) from Invitation where userId=:user_id and inviters=:inviters")
	Boolean isUserIdAndInviters(@Param("user_id") Long user_id, @Param("inviters") Long inviters);
	
	@Query(value = "from Invitation where userId=:user_id and inviters=:inviters")
	Invitation findByUserIdAndInviters(@Param("user_id") Long user_id, @Param("inviters") Long inviters);
}
