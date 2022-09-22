package bookstore.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired
	private BookRepository repository;
	

	//Listaa kaikki kirjat
	@GetMapping("/books")
	public Iterable<Book> BookListRest() {
	return repository.findAll();
	}
	
	//Etsii IDn perusteella
	@GetMapping("/books/{id}")
	Optional <Book> findBookRest(@PathVariable Long id) {
	return repository.findById(id);
	}
	
	//Lisää uuden kirjan
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		return repository.save(newBook);
	}
	
	//Muuttaa kirjan tietoja
	@PutMapping("/books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		editedBook.setId(id);
		return repository.save(editedBook);
	}
	
	//Poistaa kirjan
	@DeleteMapping("/books/{id}")
	public Iterable<Book> deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
		return repository.findAll();
	}
	
	
	
}
