package com.chex.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chex.model.Place;

public interface PlaceDAO extends JpaRepository<Place, Long> {
	
	Place findByPlaceid(String placeid);
	boolean existsByPlaceid(String placeid);
	
	@Query(value = "FROM Place where placeid like :contintent% and category = 'country' ORDER BY name")
	List<Place> uniqe_countries(@Param("contintent") String continent);
	
	@Query(value = "FROM Place where placeid like :country% and category = 'region' ORDER BY name")
	List<Place> uniqe_regions(@Param ("country") String country);
	
	@Query(value = "FROM Place where placeid like :regio% and (category= 'city' or category='reg') ORDER BY name")
	List<Place> uniqe_subreg(@Param ("regio") String regio);
	
	@Query(value = "FROM Place where placeid like :place% and (category != 'city' and category !='reg') ORDER BY name")
	List<Place> uniqe_place(@Param ("place") String place);
	
}
// category = 'country' and 