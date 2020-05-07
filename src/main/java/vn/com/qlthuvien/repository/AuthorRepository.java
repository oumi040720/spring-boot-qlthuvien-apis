package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public List<Author> findAllByAuthorNameContaining(String authorName);
	
}
