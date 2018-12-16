package com.manoj.training.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.manoj.training.model.Book;

@Service
public class BookService {

	Logger LOGGER = LoggerFactory.getLogger(BookService.class);
	private Map<String, Book> bookStore = new HashMap<>();
	@Cacheable(cacheNames= "book", key="#id", unless="#result == null")
	public Book getBook(String id)
	{	
		LOGGER.info("Returning book object from bookStore map for id -{}", id);
		return bookStore.get(id);
		
	}
	public void addBook(Book book) {
		bookStore.put(book.getId(), book);
	}
}
