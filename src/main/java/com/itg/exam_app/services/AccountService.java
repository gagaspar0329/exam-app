package com.itg.exam_app.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itg.exam_app.entity.AccountEntity;
import com.itg.exam_app.repository.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<AccountEntity> findByCustomNumberAndAccountType(Long customerNumber,String AccountType){
		return accountRepository.findByCustomNumberAndAccountType(customerNumber, AccountType);
	}
}
