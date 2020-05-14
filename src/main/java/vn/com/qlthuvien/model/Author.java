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

@Entity
@Table(name = "Authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuthorID")
	private Long authorID;

	@Column(name = "AuthorName")
	@NotBlank(message = "author.NotNull.authorName")
	private String authorName;

	@Column(name = "Photo")
	@NotBlank(message = "author.NotNull.photo")
	private String photo;

	@Column(name = "Status")
	@NotNull(message = "author.NotNull.status")
	private Boolean status;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<BookAuthor> bookAuthors;

	public Long getAuthorID() {
		return authorID;
	}

	public void setAuthorID(Long authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public List<BookAuthor> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(List<BookAuthor> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

}
