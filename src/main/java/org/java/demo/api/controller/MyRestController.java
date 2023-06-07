package org.java.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.api.controller.dto.BookResponseDto;
import org.java.demo.pojo.Book;
import org.java.demo.serv.BookServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MyRestController {

	@Autowired
	private BookServ bookServ;
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		
		return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> books = bookServ.findAll();
		
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<BookResponseDto> storeBook(
			@RequestBody Book book) {
		
//		if (bindingResult.hasErrors()) {
//			
//			return new ResponseEntity<>(
//					new BookResponseDto(bindingResult), 
//					HttpStatus.BAD_REQUEST
//				);
//		}
		
		book = bookServ.save(book);
		
		return new ResponseEntity<>(
				new BookResponseDto(book), 
				HttpStatus.OK);	
	}
	
	@PutMapping("/books")
	public ResponseEntity<BookResponseDto> updateBook(
			@RequestBody Book book
		) {
		
		book = bookServ.save(book);
		
		return new ResponseEntity<>(
				new BookResponseDto(book), 
				HttpStatus.OK);	
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<BookResponseDto> deleteBook(
			@PathVariable int id
		) {
		
		Optional<Book> optBook = bookServ.findById(id);
		
		if (optBook.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);	
		}
		
		Book book = optBook.get();
		bookServ.delete(book);
		
		return new ResponseEntity<>(
				new BookResponseDto(book), 
				HttpStatus.OK);	
	}
}
