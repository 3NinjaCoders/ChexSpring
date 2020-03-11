package com.chex.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chex.model.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {

}
