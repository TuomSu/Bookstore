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



@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Log.info("save a couple of books");
			
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Art"));
			crepository.save(new Category("History"));
			
			repository.save(new Book("Eka kirja", "John Johnson", "978-951-98548-9-2", 1978, 52, crepository.findByName("Scifi").get(0)));
			repository.save(new Book("Toka kirja", "Maria Mallikas", "978-951-98500-9-2",1987, 70, crepository.findByName("Art").get(0)));
			repository.save(new Book("Kolmas kirja", "Ted Tomson", "978-951-99500-9-2",2000, 100, crepository.findByName("History").get(0)));
			
			Log.info("fetch all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
		}

}
