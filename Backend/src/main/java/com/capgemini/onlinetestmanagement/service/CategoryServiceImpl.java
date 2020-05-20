package com.capgemini.onlinetestmanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.onlinetestmanagement.dao.CategoryDao;
import com.capgemini.onlinetestmanagement.entity.Category;
import com.capgemini.onlinetestmanagement.exception.CategoryException;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public boolean addCategory(Category category) {
		Category testresult = categoryDao.save(category);
		if (testresult != null) {
			return true;
		} else
			return false;
	}

	@Override
	public List<Category> showallcategory() {
		return categoryDao.findAll();
	}

	@Override
	public void deletecategory(int categoryId) {
		categoryDao.deleteById(categoryId);
	}
	
	 
	 @Override
		public String updateCategory(Category category) {
			
				Optional<Category> findById = categoryDao.findById(category.getCategoryId());
				
				if (findById.isPresent()) {
					categoryDao.save(category);
					return "Category updated";
				} else {
					throw new CategoryException("Category ID not Present!!!!!!!");
				}
			
			 
		}
	

}
