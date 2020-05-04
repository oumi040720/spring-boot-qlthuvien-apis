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
	
	@GetMapping(value = "/api/reader/{readerID}")
	public ResponseEntity<Optional<Reader>> getRoleByRoleID(@PathVariable("readerID") Long readerID) {
		return ResponseEntity.ok(readerRepository.findById(readerID));
	}
	
	@PostMapping(value = "/api/reader")
	public ResponseEntity<Reader> createRole(@RequestBody Reader reader) {
		return ResponseEntity.ok(readerRepository.save(reader));
	}
	
	@PutMapping(value = "/api/reader")
	public ResponseEntity<Reader> updateRole(@RequestBody Reader reader) {
		return ResponseEntity.ok(readerRepository.save(reader));
	}
	
	@DeleteMapping(value = "/api/reader/{readerID}")
	public ResponseEntity<String> delete(@PathVariable("readerID") Long readerID) {
		readerRepository.deleteById(readerID);
		return ResponseEntity.ok("Deleted: " + readerID);
	}
	
}
