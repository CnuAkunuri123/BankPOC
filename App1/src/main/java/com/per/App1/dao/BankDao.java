package com.per.App1.dao;

import com.per.App1.domain.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankDao extends CrudRepository<Bank, Long> {
    
    List<Bank> findAll();
}
