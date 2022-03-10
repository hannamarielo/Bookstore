package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");

			Category children = new Category("Children");
			crepository.save(children);
			Category non_fiction = new Category("Non-fiction");
			crepository.save(non_fiction);
			Category humor = new Category("Humor");
			crepository.save(humor);

			repository.save(
					new Book("Muumipappa ja meri", "Tove Jansson", 1965, "1234567890123", (float) 22.35, children));
			repository.save(new Book("Korkeintaan vähän väsynyt", "Eeva Kolu", 2020, "9789512419562", (float) 25.99,
					non_fiction));
			repository.save(new Book("Pintaremontti", "Miika Nousiainen", 2020, "0987654321098", (float) 10.99, humor));

			User user1 = new User("maija", "$2y$10$cZ.Ws6F8adsZchbNN3/DS.jG.Pc06g8K0KaTsesNif7z2NxP8FTjq",
					"maija.maijanen@email.com", "USER");
			User user2 = new User("matti", "$2y$10$1NvGZhKH.MS4QGnFr1x3se2umb3I.xLI7fE2Qv/XpvQwUmZtN/5d.",
					"matti.mattinen@email.com", "ADMIN");
			User user3 = new User("pekka", "$2y$10$HkXrjUBha2YAqIPC3pmIC.nh0GNuuTjoi7m8RrRO68v/hRj5N.LP6",
					"pekka.pekkanen@email.com", "USER");

			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}