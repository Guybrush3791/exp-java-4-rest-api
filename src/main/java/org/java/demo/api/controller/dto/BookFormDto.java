package org.java.demo.api.controller.dto;

import org.java.demo.pojo.Book;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

public class BookFormDto {

	@Valid
	private Book book;
	
	MultipartFile image;

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean hasImage() {
		
		return getImage() != null;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		
		return getBook() + "\npicture: " + 
				(hasImage() ? getImage().getOriginalFilename() : "empty")
		;
	}
}
