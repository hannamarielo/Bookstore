package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Muumipappa ja meri", "Tove Jansson", 1965, "1234-56-78-91", 20));
			repository.save(new Book("Muumilaakson marraskuu", "Tove Jansson", 1970, "9564-17-15-16", 25));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository crepository) {
		return (args) -> {
			log.info("save a category");
			crepository.save(new Category("123-45", "Scifi"));
			crepository.save(new Category("56-789", "Drama"));
			crepository.save(new Category("98-123", "Horror"));

			log.info("fetch all books");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
		};
	}
}