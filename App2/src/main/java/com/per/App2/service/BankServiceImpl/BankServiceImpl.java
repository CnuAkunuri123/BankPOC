package com.per.App2.service.BankServiceImpl;

import com.per.App2.dao.BankDao;
import com.per.App2.domain.Bank;
import com.per.App2.service.BankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;

	public List<Bank> findAll() {
		return bankDao.findAll();
	}

}
