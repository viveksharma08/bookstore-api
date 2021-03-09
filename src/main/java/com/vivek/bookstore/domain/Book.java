package com.vivek.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Book Title is required !")
	@Length(min = 3, max = 50, message = "Book Title length min 3 , max 50 characters ")
	private String title;

	@NotEmpty(message = "Author Name is required !")
	@Length(min = 3, max = 50, message = "Author Name length min 3 , max 50 characters ")
	private String author_name;

	@NotEmpty(message = "Author Name is required !")
	@Length(min = 10, max = 2000000, message = "Author Name length min 10 , max  2,000,000 characters ")
	private String text;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long id, String title, String author_name, String text, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author_name = author_name;
		this.text = text;
		this.category = category;
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

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
