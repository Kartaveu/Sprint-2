package com.capgemini.onlinetestmanagement.service;

import java.util.List;


import com.capgemini.onlinetestmanagement.entity.Category;

public interface CategoryService {

	boolean addCategory(Category category);

	List<Category> showallcategory();
	
	public String updateCategory(Category category);
	
	public void deletecategory(int categoryId);
}
