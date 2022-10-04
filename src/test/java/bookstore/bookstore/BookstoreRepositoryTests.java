package bookstore.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@DataJpaTest
class BookstoreRepositoryTests {

	@Autowired
	BookRepository bRepository;
	
	@Autowired
	CategoryRepository cRepository;
	
	@Test
	public void findBookcategorybyId() {
		Category category = bRepository.findById((long)6).get().getCategory();
		System.out.println("Haetaan id:llä 6 " + category);
		assertEquals(category.getName(), "History");
	}
	
	@Test
	public void findBookTitlebyId() {
		Book book = bRepository.findById((long)6).get();
		System.out.println("Haetaan id:llä 6 " + book);
		assertEquals(book.getTitle(), "Kolmas kirja");
	}

	@Test
	public void insertNewBook() {
		Book book = new Book("Testataan kirjan lisäämistä", "J J", "978-951-98548-9-2", 1978, 52, cRepository.findByName("Scifi").get(0));
		bRepository.save(book);
		assertNotNull(book.getId());
	}
	
	@Test
	public void DeleteBookbyId() {
		Book book = bRepository.findById((long)4).get();
		System.out.println("Poistetaan id:llä 4 " + book);
		
		//bRepository.deleteById());
		assertEquals(book.getId(), null);
	}
}
