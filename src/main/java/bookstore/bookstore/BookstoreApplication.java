package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.User;
import bookstore.bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			Log.info("save a couple of books");
			
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Art"));
			crepository.save(new Category("History"));
			
			repository.save(new Book("Eka kirja", "John Johnson", "978-951-98548-9-2", 1978, 52, crepository.findByName("Scifi").get(0)));
			repository.save(new Book("Toka kirja", "Maria Mallikas", "978-951-98500-9-2",1987, 70, crepository.findByName("Art").get(0)));
			repository.save(new Book("Kolmas kirja", "Ted Tomson", "978-951-99500-9-2",2000, 100, crepository.findByName("History").get(0)));
			
			User user1 = new User("Anna","Anttonen", "USER", "user", "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom");
			User user2 = new User("Mikko","Mallikas", "ADMIN", "admin", "$2a$10$f84eQG3AzRK8En0VU4Pnj.FEipEc5XejV54XTesr9rCJI9IcovccC");
			urepository.save(user1);
			urepository.save(user2);
			
			
			Log.info("fetch all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
		}

}
