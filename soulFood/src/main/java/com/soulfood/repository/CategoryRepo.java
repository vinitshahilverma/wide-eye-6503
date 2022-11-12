package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soulfood.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	
}
