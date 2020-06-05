package com.bookshop.controller;
import com.bookshop.model.entities.Book;
import com.bookshop.service.ConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;
@RestController
public class BookConsumerController {
	@Autowired
	private ConsumerService consumerService;
	 

	@GetMapping("book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		return consumerService.getBook(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	}

