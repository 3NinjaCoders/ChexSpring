package com.chex.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chex.model.Album;

public interface AlbumDAO extends JpaRepository<Album, Long> {
	
	@Query(value = "select new java.lang.Boolean(count(*) > 0 ) from Album where userid=:userid and albumid=:albumid")
	Boolean isAlbumForUserExist(@Param("userid") Long user_is, @Param("albumid") Long albumId);
	

}
