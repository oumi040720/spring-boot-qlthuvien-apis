package vn.com.qlthuvien.model;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookID")
	private Long bookID;

	@Column(name = "BookName")
	private String bookName;

	@Column(name = "BookPhoto")
	private String bookPhoto;

	@Column(name = "BookSubject")
	private String bookSubject;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Price")
	private Double price;

	@Column(name = "PublishingYear")
	private Integer publishingYear;

	@Column(name = "Status")
	private Boolean status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PublisherID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Publisher publisher;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	private List<BookAuthor> bookAuthors;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	private List<BookCategory> bookCategories;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	private List<BillDetail> billDetails;

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPhoto() {
		return bookPhoto;
	}

	public void setBookPhoto(String bookPhoto) {
		this.bookPhoto = bookPhoto;
	}

	public String getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Integer publishingYear) {
		this.publishingYear = publishingYear;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<BookAuthor> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(List<BookAuthor> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	public List<BookCategory> getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

}
