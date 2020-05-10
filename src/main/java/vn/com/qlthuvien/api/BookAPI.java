package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	@GetMapping(value = "/api/book/search/{key}")
	public List<Book> search(@PathVariable("key") String key) {
		return bookRepository.findAllByBookNameContainingOrBookSubjectContaining(key, key);
	}
	
	@GetMapping(value = "/api/book/year/{year}")
	public List<Book> search(@PathVariable("year") Integer year) {
		return bookRepository.findAllByPublishingYearIs(year);
	}
	
	@GetMapping(value = "/api/book/page/{page}")
	public Page<Book> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return bookRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book/page/{page}/sort/{by}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return bookRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/page/{page}/sort/{by}/{sort}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/page/{page}/status/{status}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return bookRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book/page/{page}/status/{status}/sort/{by}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return bookRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/page/{page}/search/{key}")
	public Page<Book> search(@PathVariable("page") Integer page, @PathVariable("key") String key) {
		page -= 1;
		
		return bookRepository.findAllByBookNameContainingOrBookSubjectContaining(key, key, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book/page/{page}/search/{key}/sort/{by}")
	public Page<Book> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by) {
		page -= 1;
		
		return bookRepository.findAllByBookNameContainingOrBookSubjectContaining(key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/page/{page}/search/{key}/sort/{by}/{sort}")
	public Page<Book> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookRepository.findAllByBookNameContainingOrBookSubjectContaining(key, key, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookRepository.findAllByBookNameContainingOrBookSubjectContaining(key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
		
	@GetMapping(value = "/api/book/page/{page}/year/{year}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("year") Integer year) {
		page -= 1;
		
		return bookRepository.findAllByPublishingYearIs(year, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book/page/{page}/year/{year}/sort/{by}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("year") Integer year, @PathVariable("by") String by) {
		page -= 1;
		
		return bookRepository.findAllByPublishingYearIs(year, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/page/{page}/year/{year}/sort/{by}/{sort}")
	public Page<Book> getAll(@PathVariable("page") Integer page, @PathVariable("year") Integer year, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookRepository.findAllByPublishingYearIs(year, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));	
		}
		
		return bookRepository.findAllByPublishingYearIs(year, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book/{bookID}")
	public ResponseEntity<Optional<Book>> getByID(@PathVariable("bookID") Long bookID) {
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
