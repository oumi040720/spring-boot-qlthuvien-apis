package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Boolean existsByCategoryCode(String categoryCode);

	public List<Category> findAllByCategoryNameContainingOrCategoryCodeContaining(String categoryName, String categoryCode);
	
	public Page<Category> findAllByCategoryNameContainingOrCategoryCodeContaining(String categoryName, String categoryCode, Pageable pageable);
	
}
