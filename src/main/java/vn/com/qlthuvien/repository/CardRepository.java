package vn.com.qlthuvien.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	public Page<Card> findAllByStatusIs(Boolean status, Pageable pageable);
	
}
