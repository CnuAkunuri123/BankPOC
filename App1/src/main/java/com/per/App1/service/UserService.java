package com.per.App1.service;



import com.per.App1.domain.User;
import com.per.App1.domain.security.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
	
    User findByUsername(String username);

    boolean checkUsernameExists(String username);

    void save(User user);

    User createUser(User user, Set<UserRole> userRoles);

    User saveUser(User user);

    List<User> findUserList();


}
