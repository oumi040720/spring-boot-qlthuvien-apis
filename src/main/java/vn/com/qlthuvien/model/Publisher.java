package vn.com.qlthuvien.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Publishers")
public class Publisher {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PublisherID")
	private Long publisherID;

	@Column(name = "PublisherName")
	@NotBlank(message = "publisher.NotNull.name")
	private String publisherName;

	@Column(name = "Address")
	@NotBlank(message = "publisher.NotNull.address")
	private String address;

	@Column(name = "Phone")
	@Pattern(regexp = "^0[1-9]{1}[0-9]{8}", message = "publisher.format.phone")
	@NotBlank(message = "publisher.NotNull.phone")
	private String phone;

	@Column(name = "Email")
	@Pattern(regexp = EMAIL_PATTERN, message = "publisher.format.email")
	@NotBlank(message = "publisher.NotNull.email")
	private String email;

	@Column(name = "Logo")
	@NotBlank(message = "publisher.NotNull.logo")
	private String logo;

	@Column(name = "Status")
	@NotNull(message = "publisher.NotNull.status")
	private Boolean status;

	@OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
	private List<Book> books;

	public Long getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(Long publisherID) {
		this.publisherID = publisherID;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
