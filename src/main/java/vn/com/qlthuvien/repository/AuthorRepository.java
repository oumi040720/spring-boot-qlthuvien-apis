package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Page<Author> findAllByStatusIs(Boolean status, Pageable pageable);
	
	public List<Author> findAllByAuthorNameContaining(String authorName);
	
	public Page<Author> findAllByAuthorNameContaining(String authorName, Pageable pageable);
	
}
