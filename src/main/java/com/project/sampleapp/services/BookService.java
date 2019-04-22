package com.project.sampleapp.services;

import com.project.sampleapp.model.Book;
import com.project.sampleapp.model.*;
import com.project.sampleapp.repository.BookRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.project.sampleapp.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	 public long save(Book book) {
	      return bookRepository.save(book);
	   }

	   
	   public Book get(long id) {
	      return bookRepository.get(id);
	   }

	   
	   public List<Book> list() {
	      return bookRepository.listBooks();
	   }

	   public void update(long id, Book book) {
		   bookRepository.updateBook(id, book);
	   }

	   public void delete(long id) {
		   bookRepository.deleteBook(id);
	   }

	}