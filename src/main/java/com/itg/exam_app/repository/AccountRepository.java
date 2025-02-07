package com.itg.exam_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itg.exam_app.entity.AccountEntity;

public interface AccountRepository  extends JpaRepository<AccountEntity, Long> {
	

    @Query(value = "SELECT * FROM Account a WHERE a.customer_Number = :customerNumber and a.account_Type = :accountType", nativeQuery = true)
    List<AccountEntity> findByCustomNumberAndAccountType(@Param("customerNumber") Long customerNumber, @Param("accountType") String accountType);
}
