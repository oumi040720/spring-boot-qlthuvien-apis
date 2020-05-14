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
@Table(name = "Roles")
public class Role {

	@Id
	@Column(name = "RoleID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleID;

	@Column(name = "RoleName")
	@NotBlank(message = "role.NotNull.name")
	private String roleName;

	@Column(name = "RoleCode")
	@NotBlank(message = "role.NotNull.code")
	private String roleCode;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<User> users;

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
