package com.project.sampleapp.services;

import com.project.sampleapp.model.*;
import com.project.sampleapp.repository.BookRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.project.sampleapp.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public Book findBook(Long id){
		
		Book book=bookRepository.findBook(id);
		return book;
		
	}
	public Book createBook(Book data){
		Book book=bookRepository.createBook(data);
		return book;
	}
	public List<Book> listBooks(){
		List<Book> books=bookRepository.listBooks();
		return books;
	}

}
