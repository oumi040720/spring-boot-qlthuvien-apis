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

import vn.com.qlthuvien.model.ClassID.BookAuthorID;

@Entity
@Table(name = "Books_Authors")
public class BookAuthor {

	@EmbeddedId
	private BookAuthorID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId(value = "BookID")
	@JoinColumn(name = "BookID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId(value = "AuthorID")
	@JoinColumn(name = "AuthorID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Author author;

	@Column(name = "Status")
	private Boolean status;

	public BookAuthorID getId() {
		return id;
	}

	public void setId(BookAuthorID id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
