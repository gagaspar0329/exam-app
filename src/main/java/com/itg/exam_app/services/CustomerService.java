package com.itg.exam_app.services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itg.exam_app.entity.CustomerEntity;
import com.itg.exam_app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//#1
	public CustomerEntity createAccount(CustomerEntity newCustomer) {	
		return customerRepository.save(newCustomer);
	}
	
	public Iterable<CustomerEntity> getAllAccounts() {
		return customerRepository.findAll();
	}

	public Optional<CustomerEntity> getCustomerByCustomerNumber(Long id) {
		return customerRepository.findById(id);
	}

}
