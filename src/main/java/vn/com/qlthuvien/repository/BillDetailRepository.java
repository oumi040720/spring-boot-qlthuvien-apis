package vn.com.qlthuvien.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.BillDetail;
import vn.com.qlthuvien.model.ClassID.BillDetailID;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailID> {

	public Page<BillDetail> findAllByStatusIs(Boolean status, Pageable pageable);
	
}
