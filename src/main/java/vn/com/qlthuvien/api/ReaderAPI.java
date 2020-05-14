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

import vn.com.qlthuvien.model.Reader;
import vn.com.qlthuvien.repository.ReaderRepository;

@RestController
public class ReaderAPI {

	@Autowired
	private ReaderRepository readerRepository;

	@GetMapping(value = "/api/reader")
	public List<Reader> getAll() {
		return readerRepository.findAll();
	}
	
	@GetMapping(value = "/api/reader/search/{key}")
	public List<Reader> search(@PathVariable("key") String key) {
		return readerRepository.findAllByReaderFullnameContainingOrAddressContainingOrEmailContaining(key, key, key);
	}
	
	@GetMapping(value = "/api/reader/page/{page}")
	public Page<Reader> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return readerRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/sort/{by}")
	public Page<Reader> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return readerRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/sort/{by}/{sort}")
	public Page<Reader> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return readerRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return readerRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/status/{status}")
	public Page<Reader> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return readerRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/status/{status}/sort/{by}")
	public Page<Reader> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return readerRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<Reader> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return readerRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return readerRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/search/{key}")
	public Page<Reader> search(@PathVariable("page") Integer page, @PathVariable("key") String key) {
		page -= 1;
		
		return readerRepository.findAllByReaderFullnameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/search/{key}/sort/{by}")
	public Page<Reader> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by) {
		page -= 1;
		
		return readerRepository.findAllByReaderFullnameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/reader/page/{page}/search/{key}/sort/{by}/{sort}")
	public Page<Reader> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return readerRepository.findAllByReaderFullnameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return readerRepository.findAllByReaderFullnameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/reader/{readerID}")
	public ResponseEntity<Optional<Reader>> getByID(@PathVariable("readerID") Long readerID) {
		return ResponseEntity.ok(readerRepository.findById(readerID));
	}
	
	@PostMapping(value = "/api/reader")
	public ResponseEntity<Reader> createRole(@Validated @RequestBody Reader reader, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(readerRepository.save(reader));
	}
	
	@PutMapping(value = "/api/reader")
	public ResponseEntity<Reader> updateRole(@Validated @RequestBody Reader reader, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(readerRepository.save(reader));
	}
	
	@DeleteMapping(value = "/api/reader/{readerID}")
	public ResponseEntity<String> delete(@PathVariable("readerID") Long readerID) {
		readerRepository.deleteById(readerID);
		return ResponseEntity.ok("Deleted: " + readerID);
	}
	
}
