package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import vn.com.qlthuvien.model.Role;
import vn.com.qlthuvien.repository.RoleRepository;

@RestController
public class RoleAPI {

	@Autowired
	private RoleRepository roleRepository;

	@GetMapping(value = "/api/role")
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
	
	@GetMapping(value = "/api/role/{roleID}")
	public ResponseEntity<Optional<Role>> getByID(@PathVariable("roleID") Long roleID) {
		return ResponseEntity.ok(roleRepository.findById(roleID));
	}
	
	@PostMapping(value = "/api/role")
	public ResponseEntity<?> create(@Validated @RequestBody Role role, BindingResult bindingResult) {
		if (roleRepository.existsByRoleCode(role.getRoleCode())) {
			bindingResult.rejectValue("roleCode", "role.exists.code");
		}
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(bindingResult.getAllErrors());
		}
		
		return ResponseEntity.ok(roleRepository.save(role));
	}
	
	@PutMapping(value = "/api/role")
	public ResponseEntity<Role> update(@Validated @RequestBody Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(roleRepository.save(role));
	}
	
	@DeleteMapping(value = "/api/role/{roleID}")
	public ResponseEntity<String> delete(@PathVariable("roleID") Long roleID) {
		roleRepository.deleteById(roleID);
		return ResponseEntity.ok("Deleted: " + roleID);
	}
	
}
