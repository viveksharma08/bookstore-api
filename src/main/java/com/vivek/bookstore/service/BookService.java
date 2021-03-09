package com.vivek.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.bookstore.domain.Book;
import com.vivek.bookstore.domain.Category;
import com.vivek.bookstore.exception.ObjectNotFoundException;
import com.vivek.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	CategoryService categoryService;

	@Autowired
	BookRepository bookRepository;

	public Book findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);

		return book.orElseThrow(() -> {
			return new ObjectNotFoundException("book id not found !: type" + Book.class.getName());
		});

	}

	public List<Book> findAll(Long id_cat) {
		categoryService.findById(id_cat);
		return bookRepository.findAllByCategory(id_cat);
	}

	public Book update(Long id, Book obj) {
		Book newObj = findById(id);
		updateData(newObj, obj);
		return bookRepository.save(newObj);
	}

	private void updateData(Book newObj, Book obj) {
		newObj.setAuthor_name(obj.getAuthor_name());
		newObj.setTitle(obj.getTitle());
		newObj.setText(obj.getText());

	}

	public Book create(Long id_cat, Book obj) {
		obj.setId(null);
		Category cat = categoryService.findById(id_cat);
		obj.setCategory(cat);
		return bookRepository.save(obj);

	}

	public void delete(Long id) {

		Book obj = findById(id);
		bookRepository.delete(obj);
	}

}
