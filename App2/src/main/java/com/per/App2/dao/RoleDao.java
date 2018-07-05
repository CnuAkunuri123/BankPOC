package com.per.App2.dao;

import com.per.App2.domain.security.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}
