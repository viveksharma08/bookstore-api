package com.vivek.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.vivek.bookstore.domain.Book;
import com.vivek.bookstore.domain.Category;
import com.vivek.bookstore.repository.BookRepository;
import com.vivek.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
