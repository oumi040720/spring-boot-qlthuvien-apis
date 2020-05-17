package vn.com.qlthuvien.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "Username")
	@NotBlank(message = "user.NotNull.username")
	private String username;

	@Column(name = "Password")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "user.NotNull.password")
	@Length(min = 6, message = "user.min.password")
	private String password;

	@Column(name = "Status")
	@NotNull(message = "user.NotNull.status")
	private Boolean status;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
	@JoinColumn(name = "RoleID", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "user.NotNull.role")
	private Role role;

	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Librarian librarian;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

}
