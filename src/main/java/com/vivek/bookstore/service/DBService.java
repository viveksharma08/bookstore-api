package com.vivek.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.bookstore.domain.Book;
import com.vivek.bookstore.domain.Category;
import com.vivek.bookstore.repository.BookRepository;
import com.vivek.bookstore.repository.CategoryRepository;

@Service
public class DBService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BookRepository bookRepository;

	public void instantiateBookDatabase() {

		Category cat1 = new Category(null, "bhopal", "bhopal Book");
		Category cat2 = new Category(null, "japan", "japan Book");

		Category cat3 = new Category(null, "china", "china Book");

		Book book1 = new Book(null, " bhopal C", "karnatak bhopal", "some c bhopal text ", cat1);
		Book book2 = new Book(null, "bhopal C", "karnatak bhopal", "some c bhopal text ", cat1);

		Book book3 = new Book(null, "C japan", "karnatak japan", "some c japan text ", cat2);
		Book book4 = new Book(null, "C japan", "karnatak japan", "some c japan text ", cat2);

		Book book5 = new Book(null, "C china", "karnatak china", "some c china text ", cat3);
		Book book6 = new Book(null, "C china", "karnatak china", "some c china text ", cat3);

		cat1.getBooks().addAll(Arrays.asList(book1, book2));
		cat2.getBooks().addAll(Arrays.asList(book3, book4));
		cat2.getBooks().addAll(Arrays.asList(book5, book6));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
	}

}
