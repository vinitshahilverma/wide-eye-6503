package com.soulfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.CategoryException;
import com.soulfood.model.Category;
import com.soulfood.service.CategoryService;



@RestController
public class CategoryController {

	@Autowired
	public CategoryService cService;
	
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat) throws CategoryException{
		
		Category cat2 = cService.addCategory(cat);
		
		return new ResponseEntity<Category>(cat2, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category cat) throws CategoryException{
		
		Category cat2 = cService.updateCategory(cat);
		
		return new ResponseEntity<Category>(cat2, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<Category> removeCategory(@PathVariable Integer categoryId) throws CategoryException{
		
		Category cat2 = cService.removeCategory(categoryId);
		
		return new ResponseEntity<Category>(cat2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewCategory/{categoryId}")
	public ResponseEntity<Category> viewCategory(@PathVariable Integer categoryId) throws CategoryException{
		
		Category cat2 = cService.viewCategory(categoryId);
		
		return new ResponseEntity<Category>(cat2, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/allCategory")
	public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException{
		
		List<Category> categoryList = cService.viewAllCategory();
		
		return new ResponseEntity<>(categoryList, HttpStatus.ACCEPTED);
	}


}
