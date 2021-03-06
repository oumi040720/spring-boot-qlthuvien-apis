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
	
	@GetMapping(value = "/api/category/search/{key}")
	public List<Category> search(@PathVariable("key") String key) {
		return categoryRepository.findAllByCategoryNameContainingOrCategoryCodeContaining(key, key);
	}
	
	@GetMapping(value = "/api/category/page/{page}")
	public Page<Category> getAll(@PathVariable("page") Integer page) {
		page -= 1; 
		
		return categoryRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/category/page/{page}/sort/{by}")
	public Page<Category> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1; 
		
		return categoryRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/category/page/{page}/sort/{by}/{sort}")
	public Page<Category> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1; 
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return categoryRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return categoryRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/category/page/{page}/search/{key}")
	public Page<Category> search(@PathVariable("page") Integer page, @PathVariable("key") String key) {
		page -= 1; 
		
		return categoryRepository.findAllByCategoryNameContainingOrCategoryCodeContaining(key, key, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/category/page/{page}/search/{key}/sort/{by}")
	public Page<Category> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by) {
		page -= 1; 
		
		return categoryRepository.findAllByCategoryNameContainingOrCategoryCodeContaining(key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/category/page/{page}/search/{key}/sort/{by}/{sort}")
	public Page<Category> search(@PathVariable("page") Integer page, @PathVariable("key") String key, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1; 
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return categoryRepository.findAllByCategoryNameContainingOrCategoryCodeContaining(key, key, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return categoryRepository.findAllByCategoryNameContainingOrCategoryCodeContaining(key, key, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/category/{categoryID}")
	public ResponseEntity<Optional<Category>> getByID(@PathVariable("categoryID") Long categoryID) {
		return ResponseEntity.ok(categoryRepository.findById(categoryID));
	}
	
	@PostMapping(value = "/api/category")
	public ResponseEntity<Category> create(@Validated @RequestBody Category category, BindingResult bindingResult) {
		if (categoryRepository.existsByCategoryCode(category.getCategoryCode())) {
			bindingResult.rejectValue("categoryCode", "category.exists.code");
		}
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(categoryRepository.save(category));
	}
	
	@PutMapping(value = "/api/category")
	public ResponseEntity<Category> update(@Validated @RequestBody Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}

		return ResponseEntity.ok(categoryRepository.save(category));
	}
	
	@DeleteMapping(value = "/api/category/{categoryID}")
	public ResponseEntity<String> delete(@PathVariable("categoryID") Long categoryID) {
		try {
			if (categoryRepository.getOne(categoryID).getBookCategories().isEmpty()) {
				categoryRepository.deleteById(categoryID);
				return ResponseEntity.ok("category.delete.success");
			} else {
				return ResponseEntity.ok("category.delete.using.book_category");
			}
		} catch (Exception e) {
			return ResponseEntity.ok("category.delete.fail");
		}
	}
	
}
