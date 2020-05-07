package vn.com.qlthuvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	List<User> findAllByUsernameContaining(String username);
	
}
