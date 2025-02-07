package com.itg.exam_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.itg.exam_app.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	

}
