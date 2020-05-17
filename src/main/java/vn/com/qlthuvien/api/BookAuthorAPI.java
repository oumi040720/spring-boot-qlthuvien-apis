package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	@GetMapping(value = "/api/book_author/page/{page}/sort/{by}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return bookAuthorRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_author/page/{page}/sort/{by}/{sort}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookAuthorRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookAuthorRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_author/page/{page}/status/{status}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return bookAuthorRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book_author/page/{page}/status/{status}/sort/{by}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status,  @PathVariable("by") String by) {
		page -= 1;
		
		return bookAuthorRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_author/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<BookAuthor> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status,  @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookAuthorRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookAuthorRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_author/{bookID}/{authorID}")
	public ResponseEntity<Optional<BookAuthor>> getByID(@PathVariable("bookID") Long bookID, @PathVariable("authorID") Long authorID) {
		BookAuthorID id = new BookAuthorID(bookID, authorID);
		
		return ResponseEntity.ok(bookAuthorRepository.findById(id));
	}
	
	@PostMapping(value = "/api/book_author")
	public ResponseEntity<BookAuthor> create(@Validated @RequestBody BookAuthor bookAuthor, BindingResult bindingResult) {
		if (bookAuthorRepository.existsById(bookAuthor.getId())) {
			bindingResult.rejectValue("id", "book_author.exists.id");
		}
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(bookAuthorRepository.save(bookAuthor));
	}
	
	@PutMapping(value = "/api/book_author")
	public ResponseEntity<BookAuthor> update(@Validated @RequestBody BookAuthor bookAuthor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(bookAuthorRepository.save(bookAuthor));
	}
	
	@DeleteMapping(value = "/api/book_author/{bookID}/{authorID}")
	public ResponseEntity<String> delete(@PathVariable("bookID") Long bookID, @PathVariable("authorID") Long authorID) {
		try {
			BookAuthorID id = new BookAuthorID(bookID, authorID);
			bookAuthorRepository.deleteById(id);
			return ResponseEntity.ok("book_author.delete.success");
		} catch (Exception e) {
			return ResponseEntity.ok("book_author.delete.fail");
		}
	}
	
}
