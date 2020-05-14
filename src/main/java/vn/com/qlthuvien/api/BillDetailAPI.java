package vn.com.qlthuvien.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	@GetMapping(value = "/api/bill_detail/page/{page}")
	public Page<BillDetail> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return billDetailRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/bill_detail/page/{page}/sort/{by}")
	public Page<BillDetail> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by) {
		page -= 1;
		
		return billDetailRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/bill_detail/page/{page}/sort/{by}/{sort}")
	public Page<BillDetail> getAll(@PathVariable("page") Integer page, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return billDetailRepository.findAll(PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return billDetailRepository.findAll(PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/bill_detail/page/{page}/status/{status}")
	public Page<BillDetail> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return billDetailRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/bill_detail/page/{page}/status/{status}/sort/{by}")
	public Page<BillDetail> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by) {
		page -= 1;
		
		return billDetailRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	@GetMapping(value = "/api/bill_detail/page/{page}/status/{status}/sort/{by}/{sort}")
	public Page<BillDetail> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status, @PathVariable("by") String by, @PathVariable("sort") String sort) {
		page -= 1;
		
		if (sort.equals("DESC") || sort.equals("desc") || sort.equals("true") || sort.equals("1")) {
			return billDetailRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(Direction.DESC, by)));
		}
		
		return billDetailRepository.findAllByStatusIs(status, PageRequest.of(page, 10, Sort.by(by)));
	}
	
	
	@GetMapping(value = "/api/bill_detail/{billID}/{bookID}")
	public ResponseEntity<Optional<BillDetail>> getByID(@PathVariable("billID") Long billID, @PathVariable("bookID") Long bookID) {
		BillDetailID id = new BillDetailID(billID, bookID);
		
		return ResponseEntity.ok(billDetailRepository.findById(id));
	}
	
	@PostMapping(value = "/api/bill_detail")
	public ResponseEntity<BillDetail> create(@Validated @RequestBody BillDetail billDetail, BindingResult bindingResult) {
		if (billDetailRepository.existsById(billDetail.getId())) {
			bindingResult.rejectValue("id", "billDetail.exists.id");
		}
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.ok(billDetailRepository.save(billDetail));
	}
	
	@PutMapping(value = "/api/bill_detail")
	public ResponseEntity<BillDetail> update(@Validated @RequestBody BillDetail billDetail, BindingResult bindingResult) {
		return ResponseEntity.ok(billDetailRepository.save(billDetail));
	}
	
	@DeleteMapping(value = "/api/bill_detail/{billID}/{bookID}")
	public ResponseEntity<String> delete(@PathVariable("billID") Long billID, @PathVariable("bookID") Long bookID) {
		BillDetailID id = new BillDetailID(billID, bookID);
		
		billDetailRepository.deleteById(id);
		return ResponseEntity.ok("Deleted: " + bookID);
	}
	
}
