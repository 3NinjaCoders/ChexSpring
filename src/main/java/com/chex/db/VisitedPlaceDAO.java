package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chex.model.VisitedPlace;

public interface VisitedPlaceDAO extends JpaRepository<VisitedPlace, Long> {
	List<VisitedPlace> findByUserid(Long userId);
	VisitedPlace findByAlbumid(Long albumId);
	VisitedPlace findByPlaceid(String placeId);
	
	List<VisitedPlace> findTopByOrderByPkAsc();
}
