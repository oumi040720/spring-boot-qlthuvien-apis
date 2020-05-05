package vn.com.qlthuvien.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import vn.com.qlthuvien.model.ClassID.BookCategoryID;

@Entity
@Table(name = "Books_Categories")
public class BookCategory {

	@EmbeddedId
	private BookCategoryID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId(value = "BookID")
	@JoinColumn(name = "BookID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId(value = "CategoryID")
	@JoinColumn(name = "CategoryID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Category category;

	@Column(name = "Status")
	private Boolean status;

	public BookCategoryID getId() {
		return id;
	}

	public void setId(BookCategoryID id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
