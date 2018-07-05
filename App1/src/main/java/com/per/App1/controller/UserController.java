package com.per.App1.controller;

import com.per.App1.dao.RoleDao;
import com.per.App1.domain.User;
import com.per.App1.domain.security.UserRole;
import com.per.App1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDao roleDao;

   @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE
                                , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String createUser(@RequestBody User user) {

        String status= "";
        if (userService.checkUsernameExists(user.getUsername())) {
            status =  "user trying to register already exists in the App1.";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            status = "user successfully created";
        }
        return status;
    }

}

