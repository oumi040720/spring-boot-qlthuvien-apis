package vn.com.qlthuvien.model.ClassID;

import java.io.Serializable;

import vn.com.qlthuvien.model.Book;
import vn.com.qlthuvien.model.Category;

public class BookCategoryID implements Serializable {

	private static final long serialVersionUID = -4491880486335193840L;

	private Book book;

	private Category category;

	public BookCategoryID() {
	}

	public BookCategoryID(Book book, Category category) {
		super();
		this.book = book;
		this.category = category;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}

}
