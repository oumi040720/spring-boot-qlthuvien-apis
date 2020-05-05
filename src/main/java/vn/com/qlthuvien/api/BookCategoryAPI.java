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
	
	@GetMapping(value = "/api/book_category/{bookID}/{categoryID}")
	public ResponseEntity<Optional<BookCategory>> getRoleByRoleID(@PathVariable("bookID") Long bookID, @PathVariable("categoryID") Long categoryID) {
		BookCategoryID id = new BookCategoryID(bookID, categoryID);
		
		return ResponseEntity.ok(bookCategoryRepository.findById(id));
	}
	
	@PostMapping(value = "/api/book_category")
	public ResponseEntity<BookCategory> createRole(@RequestBody BookCategory bookCategory) {
		return ResponseEntity.ok(bookCategoryRepository.save(bookCategory));
	}
	
	@PutMapping(value = "/api/book_category")
	public ResponseEntity<BookCategory> updateRole(@RequestBody BookCategory bookCategory) {
		return ResponseEntity.ok(bookCategoryRepository.save(bookCategory));
	}
	
	@DeleteMapping(value = "/api/book_category/{bookID}/{categoryID}")
	public ResponseEntity<String> delete(@PathVariable("bookID") Long bookID, @PathVariable("categoryID") Long categoryID) {
		BookCategoryID id = new BookCategoryID(bookID, categoryID);
		
		bookCategoryRepository.deleteById(id);
		return ResponseEntity.ok("Deleted: " + categoryID);
	}
	
}
