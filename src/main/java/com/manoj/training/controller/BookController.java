package com.manoj.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.training.model.Book;
import com.manoj.training.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	  private BookService bookService;

	@GetMapping("/book/{id}")
	public  Book getBook(@PathVariable("id") String id){
		
		return bookService.getBook(id);
	}
	
	@RequestMapping(name="/books/add", method=RequestMethod.POST, consumes="application/json")
	@ResponseStatus(code=HttpStatus.OK)
	public void addBook(@RequestBody Book book){
		bookService.addBook(book);
	}
}
