package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private float price;

	@JsonIgnoreProperties("books")
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book(String title, String author, int year, String isbn, float price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public float getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Bookstore [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn="
					+ isbn + ", price=" + price + " category =" + this.getCategory() + "]";
		else
			return "Bookstore [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn="
					+ isbn + ", price=" + price + "]";
	}

}