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

import vn.com.qlthuvien.model.BookCategory;
import vn.com.qlthuvien.model.ClassID.BookCategoryID;
import vn.com.qlthuvien.repository.BookCategoryRepository;

@RestController
public class BookCategoryAPI {

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@GetMapping(value = "/api/book_category")
	public List<BookCategory> getAll() {
		return bookCategoryRepository.findAll();
	}
	
	@GetMapping(value = "/api/book_category/page/{page}")
	public Page<BookCategory> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return bookCategoryRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book_category/page/{page}/sort/{by}")
	public Page<BookCategory> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return bookCategoryRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_category/page/{page}/sort/{by}/{sort}")
	public Page<BookCategory> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookCategoryRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookCategoryRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_category/page/{page}/status/{status}")
	public Page<BookCategory> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return bookCategoryRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/book_category/page/{page}/status/{status}/sort/{by}")
	public Page<BookCategory> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return bookCategoryRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_category/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<BookCategory> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return bookCategoryRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return bookCategoryRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/book_category/{bookID}/{categoryID}")
	public ResponseEntity<Optional<BookCategory>> getByID(@PathVariable("bookID") Long bookID, @PathVariable("categoryID") Long categoryID) {
		BookCategoryID id = new BookCategoryID(bookID, categoryID);
		
		return ResponseEntity.ok(bookCategoryRepository.findById(id));
	}
	
	@PostMapping(value = "/api/book_category")
	public ResponseEntity<BookCategory> create(@Validated @RequestBody BookCategory bookCategory, BindingResult bindingResult) {
		if(bookCategoryRepository.existsById(bookCategory.getId())) {
			bindingResult.rejectValue("id", "book_category.exists.id");
		}
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(bookCategoryRepository.save(bookCategory));
	}
	
	@PutMapping(value = "/api/book_category")
	public ResponseEntity<BookCategory> update(@Validated @RequestBody BookCategory bookCategory, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(bookCategoryRepository.save(bookCategory));
	}
	
	@DeleteMapping(value = "/api/book_category/{bookID}/{categoryID}")
	public ResponseEntity<String> delete(@PathVariable("bookID") Long bookID, @PathVariable("categoryID") Long categoryID) {
		try {
			BookCategoryID id = new BookCategoryID(bookID, categoryID);
			bookCategoryRepository.deleteById(id);
			return ResponseEntity.ok("book_category.delete.success");
		} catch (Exception e) {
			return ResponseEntity.ok("book_category.delete.fail");
		}
	}
	
}
