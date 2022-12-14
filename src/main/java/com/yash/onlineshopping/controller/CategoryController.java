/**
 * 
 */
package com.yash.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.onlineshopping.model.productcat.Category;
import com.yash.onlineshopping.service.CategoryService;

/**
 * @author namrata.jagtap
 *
 */
@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// add category
	@PostMapping("/")
	public ResponseEntity<Category>addCategory(@RequestBody Category category) {
		Category category1 = this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);

	}

	//get category
	@GetMapping("/{catId}")
	public Category getCategory(@PathVariable("catId") Long catId) {
		return this.categoryService.getCategory(catId);

	}
	
	//get All category
	@GetMapping("/")
	public ResponseEntity<?>getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//update
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
	//delete
	@DeleteMapping("/{catId}")
	public void deleteCategory(@PathVariable("catId")Long CatId) {
		this.categoryService.deleteCategory(CatId);
	}
	
}
