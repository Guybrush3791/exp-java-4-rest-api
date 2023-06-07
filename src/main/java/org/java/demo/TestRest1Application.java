package org.java.demo;

import org.java.demo.pojo.Book;
import org.java.demo.serv.BookServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRest1Application implements CommandLineRunner {

	@Autowired
	private BookServ bookServ;
	
	public static void main(String[] args) {
		SpringApplication.run(TestRest1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Book b1 = new Book("book 1", "desc 1", 50);
		Book b2 = new Book("book 2", "desc 2", 150);
		Book b3 = new Book("book 3", "desc 3", 250);
		Book b4 = new Book("book 4", "desc 4", 25);
		Book b5 = new Book("book 5", "desc 5", 10);
		
		bookServ.save(b1);
		bookServ.save(b2);
		bookServ.save(b3);
		bookServ.save(b4);
		bookServ.save(b5);
	}
}
