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

import vn.com.qlthuvien.model.Card;
import vn.com.qlthuvien.repository.CardRepository;

@RestController
public class CardAPI {

	@Autowired
	private CardRepository cardRepository;

	@GetMapping(value = "/api/card")
	public List<Card> getAll() {
		return cardRepository.findAll();
	}
	
	@GetMapping(value = "/api/card/page/{page}")
	public Page<Card> getAll(@PathVariable("page") Integer page) {
		page -= 1;
		
		return cardRepository.findAll(PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/card/page/{page}/status/{status}")
	public Page<Card> getAll(@PathVariable("page") Integer page, @PathVariable("status") Boolean status) {
		page -= 1;
		
		return cardRepository.findAllByStatusIs(status, PageRequest.of(page, 10));
	}
	
	@GetMapping(value = "/api/card/{cardID}")
	public ResponseEntity<Optional<Card>> getByID(@PathVariable("cardID") Long cardID) {
		return ResponseEntity.ok(cardRepository.findById(cardID));
	}
	
	@PostMapping(value = "/api/card")
	public ResponseEntity<Card> createRole(@RequestBody Card card) {
		return ResponseEntity.ok(cardRepository.save(card));
	}
	
	@PutMapping(value = "/api/card")
	public ResponseEntity<Card> updateRole(@RequestBody Card card) {
		return ResponseEntity.ok(cardRepository.save(card));
	}
	
	@DeleteMapping(value = "/api/card/{cardID}")
	public ResponseEntity<String> delete(@PathVariable("cardID") Long cardID) {
		cardRepository.deleteById(cardID);
		return ResponseEntity.ok("Deleted: " + cardID);
	}
	
}
