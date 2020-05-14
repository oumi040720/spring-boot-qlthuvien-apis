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

@Entity
@Table(name = "Categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private Long categoryID;

	@Column(name = "CategoryName")
	@NotBlank(message = "category.NotNull.name")
	private String categoryName;

	@Column(name = "CategoryCode")
	@NotBlank(message = "category.NotNull.code")
	private String categoryCode;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<BookCategory> bookCategories;

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public List<BookCategory> getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

}
