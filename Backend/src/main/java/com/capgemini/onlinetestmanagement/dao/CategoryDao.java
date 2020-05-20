package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.onlinetestmanagement.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
