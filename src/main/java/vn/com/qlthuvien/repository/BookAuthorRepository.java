package vn.com.qlthuvien.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.BookAuthor;
import vn.com.qlthuvien.model.ClassID.BookAuthorID;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorID> {

	public Page<BookAuthor> findAllByStatusIs(Boolean status, Pageable pageable);
	
}
