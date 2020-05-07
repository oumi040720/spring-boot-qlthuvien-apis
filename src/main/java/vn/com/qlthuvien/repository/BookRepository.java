package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findAllByBookNameContainingOrBookSubjectContaining(String bookName, String bookSubject);
	
}
