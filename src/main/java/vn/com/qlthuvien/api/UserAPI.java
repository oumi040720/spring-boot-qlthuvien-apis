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
	
	@GetMapping(value = "/api/user/search/{key}")
	public List<User> search(@PathVariable("key") String key) {
		return userRepository.findAllByUsernameContaining(key);
	}
	
	@GetMapping(value = "/api/user/page/{page}")
	public Page<User> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return userRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/user/page/{page}/sort/{by}")
	public Page<User> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return userRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/user/page/{page}/sort/{by}/{sort}")
	public Page<User> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return userRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return userRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/user/page/{page}/status/{status}")
	public Page<User> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return userRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/user/page/{page}/status/{status}/sort/{by}")
	public Page<User> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return userRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/user/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<User> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return userRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return userRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/user/page/{page}/search/{key}")
	public Page<User> search(@PathVariable("page") Integer page, @PathVariable("key") String key) {
		page -= 1;
		
		return userRepository.findAllByUsernameContaining(key, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/user/page/{page}/search/{key}/sort/{by}")
	public Page<User> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by) {
		page -= 1;
		
		return userRepository.findAllByUsernameContaining(key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/user/page/{page}/search/{key}/sort/{by}/{sort}")
	public Page<User> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return userRepository.findAllByUsernameContaining(key, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return userRepository.findAllByUsernameContaining(key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/user/{username}")
	public ResponseEntity<Optional<User>> getByID(@PathVariable("username") String username) {
		return ResponseEntity.ok(userRepository.findById(username));
	}
	
	@PostMapping(value = "/api/user")
	public ResponseEntity<?> create(@Validated @RequestBody User user, BindingResult bindingResult) {
		if (userRepository.existsById(user.getUsername())) {
			bindingResult.rejectValue("username", "user.exists.username");
		}
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(bindingResult.getAllErrors());
		}
		
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	@PutMapping(value = "/api/user")
	public ResponseEntity<User> updateRole(@Validated @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	@DeleteMapping(value = "/api/user/{username}")
	public ResponseEntity<String> delete(@PathVariable("username") String username) {
		try {
			if (userRepository.getOne(username).getLibrarian() == null) {
				userRepository.deleteById(username);
				return ResponseEntity.ok("user.delete.success");
			} else {
				return ResponseEntity.ok("user.delete.using.librarian");
			}	
		} catch (Exception e) {
			return ResponseEntity.ok("user.delete.fail");
		}
	}
	
}
