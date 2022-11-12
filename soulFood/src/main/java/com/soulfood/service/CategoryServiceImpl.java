package com.soulfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.CategoryException;
import com.soulfood.model.Category;
import com.soulfood.repository.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepo cRepo;
	
	@Override
	public Category addCategory(Category cat) throws CategoryException {
		// TODO Auto-generated method stub
		
		if(cat == null) {
			throw new CategoryException("Category not be null");
		}
		return cRepo.save(cat);
	}

	@Override
	public Category updateCategory(Category cat) throws CategoryException {
		// TODO Auto-generated method stub
		
		Category category = cRepo.findById(cat.getCatId()).orElseThrow(() -> new CategoryException("Category not available for updation"));
		
		
		return cRepo.save(category);
	}

	

	@Override
	public Category viewCategory(Integer categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Category category = cRepo.findById(categoryId).orElseThrow(() -> new CategoryException("Category not available for view"));
		
		return category;
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		
		List<Category> categories = cRepo.findAll();
		
		if(categories == null) {
			throw new CategoryException("Categories is empty");
		}
		return categories;
	}

	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException {
		Category category = cRepo.findById(categoryId).orElseThrow(() -> new CategoryException("Category not available for deletation"));
		
		cRepo.deleteById(categoryId);
		
		return category;
	}

}
