package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository brepository;

	@Autowired
	private CategoryRepository crepository;
	@Test
	public void findByTitleTest() {
		List<Book> books = brepository.findByTitle("Muumipappa ja meri");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Tove Jansson");
	}
	
    public void createNewBook() {
    	Category fiction = new Category("Fiction");
		crepository.save(fiction);
    	Book book = new Book("Margarita", "Anni Kytömäki", 2020, "9789512420704", (float) 15.95, fiction);
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }   
}
