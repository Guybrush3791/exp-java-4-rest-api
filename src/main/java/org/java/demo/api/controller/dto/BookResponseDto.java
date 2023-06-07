package org.java.demo.api.controller.dto;

import org.java.demo.pojo.Book;
import org.springframework.validation.BindingResult;

public class BookResponseDto {

	Book book;
	BindingResult bindingResult;
	
	public BookResponseDto(Book book) {
			
			setBook(book);
		}
	public BookResponseDto(BindingResult bindingResult) {
		
		setBindingResult(bindingResult);
	}
	public BookResponseDto(Book book, BindingResult bindingResult) {
		
		setBook(book);
		setBindingResult(bindingResult);
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BindingResult getBindingResult() {
		return bindingResult;
	}
	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
}
