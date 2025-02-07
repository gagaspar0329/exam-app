package com.itg.exam_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_NUMBER")
	protected Long id;

	@Column(name="CUSTOMER_NUMBER",length = 50,nullable = false)
	@JsonProperty("customerNumber") 
	protected String customerNumber;
		
	@Column(name="ACCOUNT_TYPE",length = 10,nullable = false)
	@JsonProperty("accountType")
	protected String accountType;
		
	@Column(name="AVAILABLE_BALANCE",nullable = false)
	@JsonProperty("availableBalance")
	protected double availableBalance;

	public Long getAccountNumber() {
		return id;
	}

	public void setAccountNumber(Long id) {
		this.id = id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
		    
}
