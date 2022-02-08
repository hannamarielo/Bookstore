package hh.swd20.Bookstore.domain;

public class Bookstore {

	private String title;
	private String author;
	private int year;
	private String isbn;
	private float price;

	public Bookstore(String title, String author, int year, String isbn, float price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;

	}

	public Bookstore() {
		super();
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = null;
		this.price = 0;
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

	@Override
	public String toString() {
		return "Bookstore [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price="
				+ price + "]";
	}

	
}
