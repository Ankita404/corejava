package com.Bookapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookapp.dao.BookDAO;
import com.Bookapp.exception.AuthorNotFoundException;
import com.Bookapp.exception.BookNotFoundException;
import com.Bookapp.exception.CategoryNotFoundException;
import com.Bookapp.exception.IdNotFoundException;
import com.Bookapp.model.Book;

@Service

public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;
	@Override
	public void addBook(Book book) {
		bookDAO.save(book);
	}

	@Override
	public void updateBook(Book book) throws IdNotFoundException {
		
		try{
			bookDAO.save(book);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("Invalid Id/database error");
		}
	}

	@Override
	public void deleteBook(int bookid) throws IdNotFoundException {
		try{
			bookDAO.deleteById(bookid);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("Invalid Id/database error");
		}
		
	}

	@Override
	public Book getBookById(int bookid) throws IdNotFoundException {
//		1st way
//		Book book =  bookDAO.findById(bookid).get();
//		if(book==null) {
//			throw new IdNotFoundException();
//		}
//		return book;

//		2nd way
//		Optional<Book> bookOpt =  bookDAO.findById(bookid);
//		if(bookOpt.isPresent()) {
//			return bookOpt.get();
//		}else {
//			throw new IdNotFoundException();
//		}
		return bookDAO.findById(bookid)
			      .orElseThrow(()->new IdNotFoundException("Invalid id..."));
	
}

@Override
public List<Book> getAllBooks() {
	return bookDAO.findAll();
}

@Override
public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
	List<Book> bookList =  bookDAO.findByAuthor(author);
	if(bookList.isEmpty()) {
		throw new AuthorNotFoundException("Author not found");
	}
	return bookList;
}

@Override
public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
	List<Book> bookList =  bookDAO.findByCategory(category);
	if(bookList.isEmpty()) {
		throw new CategoryNotFoundException("category not found");
	}
	return bookList;
		}


@Override
public List<Book> getByCatOrTitleOrAuth(String choice) {
	String lchoice="%"+choice+"%";
	List<Book> bookList =  bookDAO.findByCatOrTitleOrAuth(lchoice);
//	List<Book> bookList =  bookDAO.findByAuthorOrCategoryOrTitle(choice,choice,choice);
	if(bookList.isEmpty()) {
		throw new BookNotFoundException("Book not found");
	}
	return bookList;
}

}
