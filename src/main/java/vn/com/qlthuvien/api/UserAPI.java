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

import vn.com.qlthuvien.model.User;
import vn.com.qlthuvien.repository.UserRepository;

@RestController
public class UserAPI {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/api/user")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/api/user/{username}")
	public ResponseEntity<Optional<User>> getRoleByRoleID(@PathVariable("username") String username) {
		return ResponseEntity.ok(userRepository.findById(username));
	}
	
	@PostMapping(value = "/api/user")
	public ResponseEntity<User> createRole(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	@PutMapping(value = "/api/user")
	public ResponseEntity<User> updateRole(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	@DeleteMapping(value = "/api/user/{username}")
	public ResponseEntity<String> delete(@PathVariable("username") String username) {
		userRepository.deleteById(username);
		return ResponseEntity.ok("Deleted: " + username);
	}
	
	
}
