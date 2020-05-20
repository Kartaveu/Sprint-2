package com.capgemini.onlinetestmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagement.entity.Category;
import com.capgemini.onlinetestmanagement.exception.CategoryException;
import com.capgemini.onlinetestmanagement.service.CategoryService;



@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@CrossOrigin
	@GetMapping("/viewallcategory")
	public ResponseEntity<List<Category>> getallcategory() {
		List<Category> categoryList = categoryService.showallcategory();
		return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/addcategory")
	public ResponseEntity<String> addAccount(@Valid @RequestBody Category category, BindingResult bindingResult)
			throws CategoryException {
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CategoryException(err);
		}
		try {
			categoryService.addCategory(category);
			return new ResponseEntity<String>("Category added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new CategoryException("Category ID already exists");
		}
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/deletecategory/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable int categoryId)
			throws CategoryException {
		try {
			categoryService.deletecategory(categoryId);
			return new ResponseEntity<String>("category deleted successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new CategoryException("Category ID not exists");
		}
	}
	
	
	
	@CrossOrigin
	@PutMapping("/updateCategory")
	public ResponseEntity<String> updateCategory( @RequestBody Category category) {
		try {
			categoryService.updateCategory(category);
			return new ResponseEntity<String>("Category Updated", HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw new CategoryException(e.getMessage());
		}
	}
	
}