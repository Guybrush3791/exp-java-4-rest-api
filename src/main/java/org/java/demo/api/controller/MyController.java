package org.java.demo.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.java.demo.api.controller.dto.BookFormDto;
import org.java.demo.pojo.Book;
import org.java.demo.serv.BookServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/")
public class MyController {

	@Autowired
	private BookServ bookServ;
	
	@GetMapping
	public String getBookIndex(Model model) {
		
		List<Book> books = bookServ.findAll();
		
		model.addAttribute("books", books);
		
		return "books-index";
	}
	@GetMapping("/create")
	public String getBookForm(Model model) {
		
		model.addAttribute("book", new BookFormDto());
		
		return "books-create";
	}
	@PostMapping("/create")
	public String storeBook(
			Model model,
			@ModelAttribute BookFormDto bookFormDto
		) {
		
		System.err.println(bookFormDto);
		
		Book book = bookFormDto.getBook();
		if (bookFormDto.hasImage()) {
			
			try {
				
				book.setImage(bookFormDto.getImage().getBytes());
			} catch (IOException e) {
				
				System.err.println("Errore salvataggio immagine: " + e.getMessage());
			}
		}
		
		bookServ.save(book);
		
		return "redirect:/";
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> serveImage(@PathVariable Integer id) {

		Book book = bookServ.findById(id).get();
		
		return ResponseEntity
					.ok()
					.contentType(MediaType.IMAGE_JPEG)
					.body(book.getImage());
	}
}
