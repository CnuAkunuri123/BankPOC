package com.per.App2.service;



import com.per.App2.domain.User;
import com.per.App2.domain.security.UserRole;


import java.util.List;
import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    boolean checkUsernameExists(String username);

    void save(User user);

    User saveUser(User user);

    List<User> findUserList();


}
