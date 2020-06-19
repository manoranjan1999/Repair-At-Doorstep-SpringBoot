package com.example.repair.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.repair.model.User;

@Transactional
public interface UserRepo extends CrudRepository<User, Integer>{

	Optional<User> findByEmailId(String emailId);

	List findAllByUserId(int i);

	Optional<User> findByUserId(int userId);
	
	@Modifying
	@Query(value = "update user set password=?1 where user_id=?2",nativeQuery = true)
	void updatePassword(String newPassword, int userId);
	
	@Query("select firstName from User where userId=?1")
	String getUserName(int userId);

	boolean existsByEmailId(String emailId);

	
	

}
