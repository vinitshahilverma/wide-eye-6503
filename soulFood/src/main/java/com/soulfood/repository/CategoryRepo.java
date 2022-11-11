package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soulfood.model.Category;
import com.soulfood.service.CategoryService;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	
}
