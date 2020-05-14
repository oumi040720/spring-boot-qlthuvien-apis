package vn.com.qlthuvien.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import vn.com.qlthuvien.model.ClassID.BillDetailID;

@Entity
@Table(name = "BillDetails")
public class BillDetail {

	@EmbeddedId
	private BillDetailID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId(value = "BillID")
	@JoinColumn(name = "BillID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Bill bill;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId(value = "BookID")
	@JoinColumn(name = "BookID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Book book;

	@Column(name = "Deadline")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "billDetail.NotNull.deadline")
	private Date deadline;

	@Column(name = "Status")
	@NotNull(message = "billDetail.NotNull.status")
	private Boolean status;

	public BillDetailID getId() {
		return id;
	}

	public void setId(BillDetailID id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
