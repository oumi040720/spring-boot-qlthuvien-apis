package vn.com.qlthuvien.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Readers")
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReaderID")
	private Long readerID;

	@Column(name = "ReaderFullname")
	private String readerFullname;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Address")
	private String address;

	@Column(name = "Email")
	private String email;

	@Column(name = "Photo")
	private String photo;

	@Column(name = "Status")
	private Boolean status;

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Card.class)
	@JoinColumn(name = "CardID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Card card;

	public Long getReaderID() {
		return readerID;
	}

	public void setReaderID(Long readerID) {
		this.readerID = readerID;
	}

	public String getReaderFullname() {
		return readerFullname;
	}

	public void setReaderFullname(String readerFullname) {
		this.readerFullname = readerFullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
