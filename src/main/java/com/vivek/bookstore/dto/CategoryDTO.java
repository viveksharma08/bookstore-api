package com.vivek.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.vivek.bookstore.domain.Category;

public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Category  name is required !")
	@Length(min = 3, max = 100, message = "Category length min 3 , max 100 characters ")
	private String name;

	@NotEmpty(message = "Description  name is required !")
	@Length(min = 3, max = 100, message = "Description length min 3 , max 100 characters ")
	private String description;

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Category obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
