package vn.com.qlthuvien.model;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Librarians")
public class Librarian {

	@Id
	@Column(name = "LibrarianID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long librarianID;;

	@Column(name = "Fullname")
	private String fullname;

	@Column(name = "Birthday")
	private String birthday;

	@Column(name = "Gender")
	private boolean gender;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Photo")
	private String photo;

	@Column(name = "Status")
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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
