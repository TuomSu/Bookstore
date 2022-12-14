package bookstore.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min = 1, message = "min size is 1")
	private String title, author, isbn;
	
	@Min(value = 1900, message = "min value is 1900")
	@Max(value = 2022, message = "max value is 2024")
	private int bookYear;
	
	@Min(value = 1, message = "min value is 1")
	private double price;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
 
 public Book() {
	super();
}



public Book(String title, String author, String isbn, int bookYear, double price, Category category) {
	super();
	this.title = title;
	this.author = author;
	this.isbn = isbn;
	this.bookYear = bookYear;
	this.price = price;
	this.category = category;
}



public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}




public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getAuthor() {
	return author;
}


public void setAuthor(String author) {
	this.author = author;
}


public int getBookYear() {
	return bookYear;
}


public void setBookYear(int year) {
	this.bookYear = year;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}





public Category getCategory() {
	return category;
}





public void setCategory(Category category) {
	this.category = category;
}





@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", bookYear=" + bookYear
			+ ", price=" + price + "]";
}
 
 
 
 
 
}
