package com.project.sampleapp.repository;

import java.util.List;

import com.project.sampleapp.model.Book;

public interface BookRepository {
	public Book findBook(Long id);
	public Book createBook(Book data);
	public List<Book> listBooks();
	public long save(Book data);
	public Book get(long id);
	public void updateBook(Long id,Book data);
	public void deleteBook(Long id);

}
