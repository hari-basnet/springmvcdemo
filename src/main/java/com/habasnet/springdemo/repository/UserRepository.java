package com.habasnet.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.habasnet.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserNameAndPassword(String userName, String password);

	@Query(value="select * from user where user_name=:username and password=:password", nativeQuery=true)
	User userLogin(@Param("username") String username, @Param("password") String password);
}
