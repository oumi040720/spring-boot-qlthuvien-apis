package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.qlthuvien.model.Bill;
import vn.com.qlthuvien.repository.BillRepository;

@RestController
public class BillAPI {

	@Autowired
	private BillRepository billRepository;

	@GetMapping(value = "/api/bill")
	public List<Bill> getAll() {
		return billRepository.findAll();
	}
	
	@GetMapping(value = "/api/bill/page/{page}")
	public Page<Bill> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return billRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/bill/{billID}")
	public ResponseEntity<Optional<Bill>> getRoleByRoleID(@PathVariable("billID") Long billID) {
		return ResponseEntity.ok(billRepository.findById(billID));
	}
	
	@PostMapping(value = "/api/bill")
	public ResponseEntity<Bill> createRole(@RequestBody Bill bill) {
		return ResponseEntity.ok(billRepository.save(bill));
	}
	
	@PutMapping(value = "/api/bill")
	public ResponseEntity<Bill> updateRole(@RequestBody Bill bill) {
		return ResponseEntity.ok(billRepository.save(bill));
	}
	
	@DeleteMapping(value = "/api/bill/{billID}")
	public ResponseEntity<String> delete(@PathVariable("billID") Long billID) {
		billRepository.deleteById(billID);
		return ResponseEntity.ok("Deleted: " + billID);
	}
	
}
