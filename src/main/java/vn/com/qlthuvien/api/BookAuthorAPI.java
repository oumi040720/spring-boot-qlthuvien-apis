package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.qlthuvien.model.BookAuthor;
import vn.com.qlthuvien.model.ClassID.BookAuthorID;
import vn.com.qlthuvien.repository.BookAuthorRepository;

@RestController
public class BookAuthorAPI {

	@Autowired
	private BookAuthorRepository bookAuthorRepository;

	@GetMapping(value = "/api/book_author")
	public List<BookAuthor> getAll() {
		return bookAuthorRepository.findAll();
	}
	
	@GetMapping(value = "/api/book_author/page/{page}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return bookAuthorRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book_author/page/{page}/status/{status}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return bookAuthorRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book_author/{bookID}/{authorID}")
	public ResponseEntity<Optional<BookAuthor>> getByID(@PathVariable("bookID") Long bookID, @PathVariable("authorID") Long authorID) {
		BookAuthorID id = new BookAuthorID(bookID, authorID);
		
		return ResponseEntity.ok(bookAuthorRepository.findById(id));
	}
	
	@PostMapping(value = "/api/book_author")
	public ResponseEntity<BookAuthor> createRole(@RequestBody BookAuthor bookAuthor) {
		return ResponseEntity.ok(bookAuthorRepository.save(bookAuthor));
	}
	
	@PutMapping(value = "/api/book_author")
	public ResponseEntity<BookAuthor> updateRole(@RequestBody BookAuthor bookAuthor) {
		return ResponseEntity.ok(bookAuthorRepository.save(bookAuthor));
	}
	
	@DeleteMapping(value = "/api/book_author/{bookID}/{authorID}")
	public ResponseEntity<String> delete(@PathVariable("bookID") Long bookID, @PathVariable("authorID") Long authorID) {
		BookAuthorID id = new BookAuthorID(bookID, authorID);
		
		bookAuthorRepository.deleteById(id);
		return ResponseEntity.ok("Deleted: " + authorID);
	}
	
}
