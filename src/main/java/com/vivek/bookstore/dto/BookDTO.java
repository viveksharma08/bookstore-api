package com.vivek.bookstore.dto;

import java.io.Serializable;

import com.vivek.bookstore.domain.Book;

public class BookDTO  implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;

	public BookDTO(Book obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
