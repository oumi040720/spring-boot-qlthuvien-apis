package vn.com.qlthuvien.model.ClassID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BookCategoryID implements Serializable {

	private static final long serialVersionUID = -4491880486335193840L;

	@Column(name = "BookID")
	@NotNull(message = "book_category.NotNull.bookID")
	private Long bookID;

	@Column(name = "CategoryID")
	@NotNull(message = "book_category.NotNull.categoryID")
	private Long categoryID;

	public BookCategoryID() {
	}

	public BookCategoryID(Long bookID, Long categoryID) {
		this.bookID = bookID;
		this.categoryID = categoryID;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
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
		BookCategoryID other = (BookCategoryID) obj;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (categoryID == null) {
			if (other.categoryID != null)
				return false;
		} else if (!categoryID.equals(other.categoryID))
			return false;
		return true;
	}

}
