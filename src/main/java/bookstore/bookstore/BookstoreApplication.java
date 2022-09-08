package bookstore.bookstore;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;



@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Log.info("save a couple of books");
			repository.save(new Book("Eka kirja", "John Johnson", "978-951-98548-9-2", 1978, 52));
			repository.save(new Book("Toka kirja", "Maria Mallikas", "978-951-98500-9-2",1987, 70));
			repository.save(new Book("Kolmas kirja", "Ted Tomson", "978-951-99500-9-2",2000, 100));
			
			Log.info("fetch all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
		}

}
