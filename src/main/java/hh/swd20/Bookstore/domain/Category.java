package hh.swd20.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;
	private String categoryname;

	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

	public Category(String categoryname) {
		super();
		this.categoryname = categoryname;
	}

	public Category() {
		super();
		this.categoryname = null;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}

}
