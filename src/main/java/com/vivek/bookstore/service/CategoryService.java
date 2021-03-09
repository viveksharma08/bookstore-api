package com.vivek.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vivek.bookstore.domain.Category;
import com.vivek.bookstore.dto.CategoryDTO;
import com.vivek.bookstore.exception.ObjectNotFoundException;
import com.vivek.bookstore.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Category findById(Long id) {

		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> {
			return new ObjectNotFoundException("Book not found for Id: " + id + ", type: " + Category.class.getName());
		});

	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category create(Category obj) {
		obj.setId(null);
		return categoryRepository.save(obj);
	}

	public Category update(Integer id, CategoryDTO objDto) {
		Category obj = findById(objDto.getId());
		obj.setName(objDto.getName());
		obj.setDescription(objDto.getDescription());
		return categoryRepository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.vivek.bookstore.exception.DataIntegrityViolationException("Book exist for this category !");
		}

	}

}
