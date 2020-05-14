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

import vn.com.qlthuvien.model.Librarian;
import vn.com.qlthuvien.repository.LibrarianRepository;

@RestController
public class LibrarianAPI {

	@Autowired
	private LibrarianRepository librarianRepository;

	@GetMapping(value = "/api/librarian")
	public List<Librarian> getAll() {
		return librarianRepository.findAll();
	}
	
	@GetMapping(value = "/api/librarian/search/{key}")
	public List<Librarian> search(@PathVariable("key") String key) {
		return librarianRepository.findAllByFullnameContainingOrEmailContaining(key, key);
	}
	
	@GetMapping(value = "/api/librarian/page/{page}")
	public Page<Librarian> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return librarianRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/sort/{by}")
	public Page<Librarian> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return librarianRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/sort/{by}/{sort}")
	public Page<Librarian> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return librarianRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return librarianRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/status/{status}")
	public Page<Librarian> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return librarianRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/status/{status}/sort/{by}")
	public Page<Librarian> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return librarianRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<Librarian> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return librarianRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return librarianRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/search/{key}")
	public Page<Librarian> search(@PathVariable("page") Integer page, @PathVariable("key") String key) {
		page -= 1;
		
		return librarianRepository.findAllByFullnameContainingOrEmailContaining(key, key, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/search/{key}/sort/{by}")
	public Page<Librarian> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by) {
		page -= 1;
		
		return librarianRepository.findAllByFullnameContainingOrEmailContaining(key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/librarian/page/{page}/search/{key}/sort/{by}/{sort}")
	public Page<Librarian> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return librarianRepository.findAllByFullnameContainingOrEmailContaining(key, key, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return librarianRepository.findAllByFullnameContainingOrEmailContaining(key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/librarian/{librarianID}")
	public ResponseEntity<Optional<Librarian>> getByID(@PathVariable("librarianID") Long librarianID) {
		return ResponseEntity.ok(librarianRepository.findById(librarianID));
	}
	
	@PostMapping(value = "/api/librarian")
	public ResponseEntity<Librarian> create(@Validated @RequestBody Librarian librarian, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(librarianRepository.save(librarian));
	}
	
	@PutMapping(value = "/api/librarian")
	public ResponseEntity<Librarian> updateRole(@Validated @RequestBody Librarian librarian, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(librarianRepository.save(librarian));
	}
	
	@DeleteMapping(value = "/api/librarian/{librarianID}")
	public ResponseEntity<String> delete(@PathVariable("librarianID") Long librarianID) {
		librarianRepository.deleteById(librarianID);
		return ResponseEntity.ok("Deleted: " + librarianID);
	}
	
}
