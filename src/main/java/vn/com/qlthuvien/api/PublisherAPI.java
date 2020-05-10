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

import vn.com.qlthuvien.model.Publisher;
import vn.com.qlthuvien.repository.PublisherRepository;

@RestController
public class PublisherAPI {

	@Autowired
	private PublisherRepository publisherRepository;

	@GetMapping(value = "/api/publisher")
	public List<Publisher> getAll() {
		return publisherRepository.findAll();
	}
	
	@GetMapping(value = "/api/publisher/search/{key}")
	public List<Publisher> search(@PathVariable("key") String key) {
		return publisherRepository.findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(key, key, key);
	}
	
	@GetMapping(value = "/api/publisher/page/{page}")
	public Page<Publisher> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return publisherRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/sort/{by}")
	public Page<Publisher> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return publisherRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/sort/{by}/{sort}")
	public Page<Publisher> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return publisherRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return publisherRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/status/{status}")
	public Page<Publisher> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return publisherRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/status/{status}/sort/{by}")
	public Page<Publisher> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return publisherRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<Publisher> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return publisherRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return publisherRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/search/{key}")
	public Page<Publisher> search(@PathVariable("page") Integer page, @PathVariable("key") String key) {
		page -= 1;
		
		return publisherRepository.findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/search/{key}/sort/{by}")
	public Page<Publisher> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by) {
		page -= 1;
		
		return publisherRepository.findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/publisher/page/{page}/search/{key}/sort/{by}/{sort}")
	public Page<Publisher> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return publisherRepository.findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return publisherRepository.findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(key, key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/publisher/{publisherID}")
	public ResponseEntity<Optional<Publisher>> getByID(@PathVariable("publisherID") Long publisherID) {
		return ResponseEntity.ok(publisherRepository.findById(publisherID));
	}
	
	@PostMapping(value = "/api/publisher")
	public ResponseEntity<Publisher> createRole(@RequestBody Publisher publisher) {
		return ResponseEntity.ok(publisherRepository.save(publisher));
	}
	
	@PutMapping(value = "/api/publisher")
	public ResponseEntity<Publisher> updateRole(@RequestBody Publisher publisher) {
		return ResponseEntity.ok(publisherRepository.save(publisher));
	}
	
	@DeleteMapping(value = "/api/publisher/{publisherID}")
	public ResponseEntity<String> delete(@PathVariable("publisherID") Long publisherID) {
		publisherRepository.deleteById(publisherID);
		return ResponseEntity.ok("Deleted: " + publisherID);
	}
	
}
