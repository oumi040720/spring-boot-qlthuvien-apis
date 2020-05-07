package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	public Page<Publisher> findAllByStatusIs(Boolean status, Pageable pageable);
	
	public List<Publisher> findAllByPublisherNameContainingOrAddressContainingOrEmailContaining(String publisherName, String address, String email);
	
}
