package com.itg.exam_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_NUMBER")
	protected Long id;

	@Column(name="CUSTOMER_NAME",length = 50,nullable = false)
	@JsonProperty("customerName") 
	protected String customerName;
		
	@Column(name="CUSTOMER_MOBILE",length = 20,nullable = false)
	@JsonProperty("customerMobile")
	protected String customerMobile;
		
	@Column(name="CUSTOMER_EMAIL",length = 50,nullable = false)
	@JsonProperty("customerEmail")
	protected String customerEmail;
		
	@Column(name="ADDRESS1",length = 100,nullable = false)
	@JsonProperty("address1")
	protected String address1;
	
	@Column(name="ADDRESS2",length = 100,nullable = true)
	@JsonProperty("address2")
	protected String address2;
	
	@Column(name="ACCOUNT_TYPE",length = 10,nullable = true)
	@JsonProperty("accountType")
//    @Enumerated(EnumType.STRING)
	protected String accountType;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	
}
