package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
