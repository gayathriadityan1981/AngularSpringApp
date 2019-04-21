package com.project.sampleapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.project.sampleapp.repository.BookRepository;
import com.project.sampleapp.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Book findBook(Long id){
		return em.find(Book.class,id);
	}
	
	@Override
	public List<Book> listBooks(){
		Query query=em.createQuery("SELECT B FROM Book B");
		return query.getResultList();
		
	}
	
	public Book findBookByName(String title){
		Query query=em.createQuery("SELECT B FROM Book B WHERE title=?1");
		query.setParameter(1,title);
		List<Book> result=query.getResultList();
		if(result.size()==0){
			return null;
		}
		else
			return result.get(0);
	}
	
	@Override
	public Book createBook(Book data){
		em.persist(data);
		return data;
	}
	
	public void deleteBook(Long id){
		Book book=em.find(Book.class, id);
		em.remove(book);
	}
	
	public void updateBook(Long id,Book data){
		Book book=em.find(Book.class, id);
		book.setAuthor(data.getAuthor());
		book.setTitle(data.getTitle());
	}

}
