package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
