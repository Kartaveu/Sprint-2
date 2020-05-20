package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="category_table")
public class Category {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="category_Id")
@NotNull
@Positive
private Integer categoryId;

@Column(name="category_name")
@NotEmpty(message="Categoryname not be nulled")
private String categoryName;

public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public Category(@NotNull @Positive Integer categoryId, @NotNull(message = "Categoryname not be nulled") String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}

public Category() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName +"]";
}


}