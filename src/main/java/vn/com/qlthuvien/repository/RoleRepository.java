package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Boolean existsByRoleCode(String roleCode);
	
}
