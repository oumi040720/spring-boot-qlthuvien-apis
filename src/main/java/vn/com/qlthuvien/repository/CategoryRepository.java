package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
