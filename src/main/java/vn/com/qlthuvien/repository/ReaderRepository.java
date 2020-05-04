package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
