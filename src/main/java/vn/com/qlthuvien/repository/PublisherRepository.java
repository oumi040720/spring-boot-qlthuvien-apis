package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	public List<Publisher> findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(String publisherName, String address, String email);
	
}
