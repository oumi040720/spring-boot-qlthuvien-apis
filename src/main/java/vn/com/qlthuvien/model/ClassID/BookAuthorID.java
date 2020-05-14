package vn.com.qlthuvien.model.ClassID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BookAuthorID implements Serializable {

	private static final long serialVersionUID = -7713154927518017630L;

	@Column(name = "BookID")
	@NotNull(message = "book_author.NotNull.bookID")
	private Long bookID;
	
	@Column(name = "AuthorID")
	@NotNull(message = "book_author.NotNull.authorID")
	private Long authorID;

	public BookAuthorID() {
	}

	public BookAuthorID(Long bookID, Long authorID) {
		this.bookID = bookID;
		this.authorID = authorID;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public Long getAuthorID() {
		return authorID;
	}

	public void setAuthorID(Long authorID) {
		this.authorID = authorID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorID == null) ? 0 : authorID.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthorID other = (BookAuthorID) obj;
		if (authorID == null) {
			if (other.authorID != null)
				return false;
		} else if (!authorID.equals(other.authorID))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		return true;
	}

}
