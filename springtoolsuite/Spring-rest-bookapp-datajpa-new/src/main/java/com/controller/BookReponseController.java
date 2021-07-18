package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bookapp.exception.AuthorNotFoundException;
import com.Bookapp.exception.CategoryNotFoundException;
import com.Bookapp.exception.IdNotFoundException;
import com.Bookapp.model.Book;
import com.Bookapp.service.BookService;


@RestController

public class BookReponseController {
	
	@Autowired
	BookService bookService;
	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book)throws IdNotFoundException{
		bookService.updateBook(book);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/books")
	ResponseEntity<Void>  deleteBook(int bookid)throws IdNotFoundException{
		bookService.deleteBook(bookid);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAllBooks(){
		List<Book> bookList = bookService.getAllBooks();
		return ResponseEntity.ok(bookList);
	}
	@GetMapping("/books-by-id/{bookid}")
	Book getBookById(@PathVariable("bookid") int bookid) throws IdNotFoundException{
		return bookService.getBookById(bookid);
	}
	
	@GetMapping("/books-by-author/{author}")
	ResponseEntity<List<Book>> getBookByAuthor(@PathVariable("author")String author) throws AuthorNotFoundException{
		List<Book> bookList = bookService.getBookByAuthor(author);
		return ResponseEntity.ok(bookList);
	}
	@GetMapping("/books-by-category/{category}")
	ResponseEntity<List<Book>> getBookByCategory(@PathVariable("category")String category) throws CategoryNotFoundException{
		List<Book> bookList = bookService.getBookByCategory(category);
		return ResponseEntity.ok(bookList);
	}
	@GetMapping("/books-by-choice/{choice}")
	ResponseEntity<List<Book>> getByCatOrTitleOrAuth(@PathVariable("choice") String choice){
		List<Book> bookList = bookService.getByCatOrTitleOrAuth(choice);
		return ResponseEntity.ok(bookList);
	}
}


