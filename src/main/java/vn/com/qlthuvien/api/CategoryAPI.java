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

import vn.com.qlthuvien.model.Category;
import vn.com.qlthuvien.repository.CategoryRepository;

@RestController
public class CategoryAPI {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping(value = "/api/category")
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	@GetMapping(value = "/api/category/page/{page}")
	public Page<Category> getAll(@PathVariable("page") Integer page) {
		page -= 1; 
		
		return categoryRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/category/{categoryID}")
	public ResponseEntity<Optional<Category>> getRoleByRoleID(@PathVariable("categoryID") Long categoryID) {
		return ResponseEntity.ok(categoryRepository.findById(categoryID));
	}
	
	@PostMapping(value = "/api/category")
	public ResponseEntity<Category> createRole(@RequestBody Category category) {
		return ResponseEntity.ok(categoryRepository.save(category));
	}
	
	@PutMapping(value = "/api/category")
	public ResponseEntity<Category> updateRole(@RequestBody Category category) {
		return ResponseEntity.ok(categoryRepository.save(category));
	}
	
	@DeleteMapping(value = "/api/category/{categoryID}")
	public ResponseEntity<String> delete(@PathVariable("categoryID") Long categoryID) {
		categoryRepository.deleteById(categoryID);
		return ResponseEntity.ok("Deleted: " + categoryID);
	}
	
}
