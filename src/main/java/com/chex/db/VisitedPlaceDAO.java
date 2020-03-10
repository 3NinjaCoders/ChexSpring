package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chex.model.VisitedPlace;

public interface VisitedPlaceDAO extends JpaRepository<VisitedPlace, Long> {
	List<VisitedPlace> findByUserId(Long userId);
	VisitedPlace findByAlbumId(Long albumId);
	VisitedPlace findByPlaceId(String placeId);
	
	List<VisitedPlace> findTopByOrderByPkAsc();
}
