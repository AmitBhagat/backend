package com.dalrada.user.integration.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dalrada.user.integration.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	
@Query("Select u from User u where u.userName = :userName")
List<User> getUserByName(@Param(value = "userName") String userName);
	
}
