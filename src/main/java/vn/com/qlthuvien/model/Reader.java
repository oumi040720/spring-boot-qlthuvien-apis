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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Readers")
public class Reader {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReaderID")
	private Long readerID;

	@Column(name = "ReaderFullname")
	@NotBlank(message = "reader.NotNull.fullname")
	private String readerFullname;

	@Column(name = "Phone")
	@NotBlank(message = "reader.NotNull.phone")
	@Pattern(regexp = "^0[1-9]{1}[0-9]{8}", message = "librarian.format.phone")
	private String phone;

	@Column(name = "Address")
	@NotBlank(message = "reader.NotNull.address")
	private String address;

	@Column(name = "Email")
	@NotBlank(message = "reader.NotNull.email")
	@Pattern(regexp = EMAIL_PATTERN, message = "reader.format.email")
	private String email;

	@Column(name = "Photo")
	@NotBlank(message = "reader.NotNull.photo")
	private String photo;

	@Column(name = "Status")
	@NotNull(message = "reader.NotNull.status")
	private Boolean status;

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Card.class)
	@JoinColumn(name = "CardID")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "reader.NotNull.card")
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
