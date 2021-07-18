package com.Bookapp.service;

import java.util.List;

import com.Bookapp.exception.AuthorNotFoundException;
import com.Bookapp.exception.CategoryNotFoundException;
import com.Bookapp.exception.IdNotFoundException;
import com.Bookapp.model.Book;

public interface BookService {

	void addBook(Book book);
	void updateBook(Book book)throws IdNotFoundException;
	void deleteBook(int bookid)throws IdNotFoundException;
	Book getBookById(int bookid) throws IdNotFoundException;
	
	List<Book> getAllBooks();
	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;
	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;
	List<Book> getByCatOrTitleOrAuth(String choice);

}
