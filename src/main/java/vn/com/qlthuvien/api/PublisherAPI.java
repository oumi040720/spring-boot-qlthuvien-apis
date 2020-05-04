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
	
	@GetMapping(value = "/api/publisher/{publisherID}")
	public ResponseEntity<Optional<Publisher>> getRoleByRoleID(@PathVariable("publisherID") Long publisherID) {
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
