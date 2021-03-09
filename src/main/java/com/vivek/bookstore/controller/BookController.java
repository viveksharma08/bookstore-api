package com.vivek.bookstore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vivek.bookstore.domain.Book;
import com.vivek.bookstore.dto.BookDTO;
import com.vivek.bookstore.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {

		Book obj = bookService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Long id_cat) {
		// localhost:8080/books?category=?
		List<Book> list = bookService.findAll(id_cat);
		List<BookDTO> listDTO = list.stream().map((obj) -> new BookDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody Book obj) {
		Book newObj = bookService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Long id, @Valid @RequestBody Book obj) {
		Book newObj = bookService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Long id_cat,
			@Valid @RequestBody Book obj) {
		Book newObj = bookService.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(newObj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
