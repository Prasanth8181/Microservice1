package com.gopistore.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category_master")
public class CategoryMasterDAOEntity
{
	@Id
	@Column(name="Category_Value")
	private String categoryValue;
	@Column(name="Category_Name")
	private String categoryDisplayName;
	
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	public String getCategoryDisplayName() {
		return categoryDisplayName;
	}
	public void setCategoryDisplayName(String categoryDisplayName) {
		this.categoryDisplayName = categoryDisplayName;
	}
	
}
