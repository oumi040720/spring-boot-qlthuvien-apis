package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.qlthuvien.model.Book;
import vn.com.qlthuvien.repository.BookRepository;

@RestController
public class BookAPI {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping(value = "/api/book")
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
	@GetMapping(value = "/api/book/{bookID}")
	public ResponseEntity<Optional<Book>> getRoleByRoleID(@PathVariable("bookID") Long bookID) {
		return ResponseEntity.ok(bookRepository.findById(bookID));
	}
	
	@PostMapping(value = "/api/book")
	public ResponseEntity<Book> createRole(@RequestBody Book book) {
		return ResponseEntity.ok(bookRepository.save(book));
	}
	
	@PutMapping(value = "/api/book")
	public ResponseEntity<Book> updateRole(@RequestBody Book book) {
		return ResponseEntity.ok(bookRepository.save(book));
	}
	
	@DeleteMapping(value = "/api/book/{bookID}")
	public ResponseEntity<String> delete(@PathVariable("bookID") Long bookID) {
		bookRepository.deleteById(bookID);
		return ResponseEntity.ok("Deleted: " + bookID);
	}
	
}
