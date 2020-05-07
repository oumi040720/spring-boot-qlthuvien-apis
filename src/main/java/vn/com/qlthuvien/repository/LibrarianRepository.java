package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

	public Page<Librarian> findAllByStatusIs(Boolean status, Pageable pageable);
	
	public List<Librarian> findAllByFullnameContainingOrEmailContaining(String fullname, String email);
	
	public Page<Librarian> findAllByFullnameContainingOrEmailContaining(String fullname, String email, Pageable pageable);
	
}
