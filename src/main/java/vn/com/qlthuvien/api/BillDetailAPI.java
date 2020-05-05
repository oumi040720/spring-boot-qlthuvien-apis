package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.qlthuvien.model.BillDetail;
import vn.com.qlthuvien.model.ClassID.BillDetailID;
import vn.com.qlthuvien.repository.BillDetailRepository;

@RestController
public class BillDetailAPI {

	@Autowired
	private BillDetailRepository billDetailRepository;

	@GetMapping(value = "/api/bill_detail")
	public List<BillDetail> getAll() {
		return billDetailRepository.findAll();
	}
	
	@GetMapping(value = "/api/bill_detail/{billID}/{bookID}")
	public ResponseEntity<Optional<BillDetail>> getRoleByRoleID(@PathVariable("billID") Long billID, @PathVariable("bookID") Long bookID) {
		BillDetailID id = new BillDetailID(billID, bookID);
		
		return ResponseEntity.ok(billDetailRepository.findById(id));
	}
	
	@PostMapping(value = "/api/bill_detail")
	public ResponseEntity<BillDetail> createRole(@RequestBody BillDetail billDetail) {
		return ResponseEntity.ok(billDetailRepository.save(billDetail));
	}
	
	@PutMapping(value = "/api/bill_detail")
	public ResponseEntity<BillDetail> updateRole(@RequestBody BillDetail billDetail) {
		return ResponseEntity.ok(billDetailRepository.save(billDetail));
	}
	
	@DeleteMapping(value = "/api/bill_detail/{billID}/{bookID}")
	public ResponseEntity<String> delete(@PathVariable("billID") Long billID, @PathVariable("bookID") Long bookID) {
		BillDetailID id = new BillDetailID(billID, bookID);
		
		billDetailRepository.deleteById(id);
		return ResponseEntity.ok("Deleted: " + bookID);
	}
	
}
