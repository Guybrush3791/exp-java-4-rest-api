package org.java.demo.pojo;

import org.hibernate.property.access.spi.GetterFieldImpl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String name;
	private String description;
	
	@PositiveOrZero
	private Integer price;
	
	public Book() { }
	public Book(String name, String description, Integer price) {
		
		setName(name);
		setDescription(description);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName()
			+ "\n" + getDescription()
			+ "\nprice: " + getPrice() + "E";
	}
}
