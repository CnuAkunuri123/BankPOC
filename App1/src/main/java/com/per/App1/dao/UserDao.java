package com.per.App1.dao;

import com.per.App1.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {
    
	User findByUsername(String username);
	
    List<User> findAll();
}
