package com.per.App1.service.BankServiceImpl;

import com.per.App1.dao.BankDao;
import com.per.App1.domain.Bank;
import com.per.App1.service.BankService;
import com.per.App1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BankDao bankDao;
	
	public List<Bank> findBanksList() {
        return bankDao.findAll();
    }

}
