package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public Page<User> findAllByStatusIs(Boolean status, Pageable pageable);
	
	public List<User> findAllByUsernameContaining(String username);
	
	public Page<User> findAllByUsernameContaining(String username, Pageable pageable);
	
}
