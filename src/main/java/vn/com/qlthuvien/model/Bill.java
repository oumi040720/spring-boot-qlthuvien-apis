package vn.com.qlthuvien.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BillID")
	private Long billID;

	@Column(name = "OrderDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "CardID")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "bill.NotNull.card")
	private Card card;

	@ManyToOne
	@JoinColumn(name = "LibrarianID")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "bill.NotNull.librarian")
	private Librarian librarian;

	@OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
	private List<BillDetail> billDetails;

	public Long getBillID() {
		return billID;
	}

	public void setBillID(Long billID) {
		this.billID = billID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

}
