package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

	public List<Librarian> findAllByFullnameContainingOrEmailContaining(String fullname, String email);
	
}
