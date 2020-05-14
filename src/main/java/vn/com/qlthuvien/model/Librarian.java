package vn.com.qlthuvien.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Librarians")
public class Librarian {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Id
	@Column(name = "LibrarianID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long librarianID;;

	@Column(name = "Fullname")
	@NotBlank(message = "librarian.NotNull.fullname")
	private String fullname;

	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "librarian.NotNull.birthday")
	private Date birthday;

	@Column(name = "Gender")
	@NotNull(message = "librarian.NotNull.gender")
	private Boolean gender;

	@Column(name = "Email")
	@NotBlank(message = "librarian.NotNull.email")
	@Pattern(regexp = EMAIL_PATTERN, message = "librarian.format.email")
	private String email;

	@Column(name = "Phone")
	@NotBlank(message = "librarian.NotNull.phone")
	@Pattern(regexp = "^0[1-9]{1}[0-9]{8}", message = "librarian.format.phone")
	private String phone;

	@Column(name = "Photo")
	@NotBlank(message = "librarian.NotNull.photo")
	private String photo;

	@Column(name = "Status")
	@NotNull(message = "librarian.NotNull.status")
	private Boolean status;

	@OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "Username")
	@JsonProperty(access = Access.WRITE_ONLY)
	private User user;

	@OneToMany(mappedBy = "librarian", fetch = FetchType.LAZY)
	private List<Bill> bills;

	public Long getLibrarianID() {
		return librarianID;
	}

	public void setLibrarianID(Long librarianID) {
		this.librarianID = librarianID;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

}
