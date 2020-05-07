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

import vn.com.qlthuvien.model.Author;
import vn.com.qlthuvien.repository.AuthorRepository;

@RestController
public class AuthorAPI {

	@Autowired
	private AuthorRepository authorRepository;

	@GetMapping(value = "/api/author")
	public List<Author> getAll() {
		return authorRepository.findAll();
	}
	
	@GetMapping(value = "/api/author/page/{page}")
	public Page<Author> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		return authorRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/author/search/{key}")
	public List<Author> search(@PathVariable("key") String key) {
		return authorRepository.findAllByAuthorNameContaining(key);
	}
	
	@GetMapping(value = "/api/author/{authorID}")
	public ResponseEntity<Optional<Author>> getByID(@PathVariable("authorID") Long authorID) {
		return ResponseEntity.ok(authorRepository.findById(authorID));
	}
	
	@PostMapping(value = "/api/author")
	public ResponseEntity<Author> createRole(@RequestBody Author author) {
		return ResponseEntity.ok(authorRepository.save(author));
	}
	
	@PutMapping(value = "/api/author")
	public ResponseEntity<Author> updateRole(@RequestBody Author author) {
		return ResponseEntity.ok(authorRepository.save(author));
	}
	
	@DeleteMapping(value = "/api/author/{authorID}")
	public ResponseEntity<String> delete(@PathVariable("authorID") Long authorID) {
		authorRepository.deleteById(authorID);
		return ResponseEntity.ok("Deleted: " + authorID);
	}
	
}
