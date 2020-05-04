package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

}
