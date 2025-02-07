package com.itg.exam_app.response.success;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itg.exam_app.entity.AccountEntity;
import com.itg.exam_app.services.AccountService;
import com.itg.exam_app.repository.AccountRepository;



@Component
public class SearchModel {

	@Autowired
	private AccountRepository accountRepository;

	private Long customerNumber;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	private List<Map<String, Object>> accounts;
	private int transactionStatusCode;
	private String transactionStatusDescription;
	
    public SearchModel() {
        this.customerNumber = 0L; // Default value
    }
	
	public SearchModel(Long cusNumber, String cusName,String cusMobile,String cusEmail, String cusAddr1, String cusAddr2,String cusAccType
			, int statusCode, String statusDesc, List<AccountEntity> cusDt) {
//		AccountService accountService = new AccountService();
		this.customerNumber = cusNumber;
		this.customerName = cusName;
		this.customerMobile = cusMobile;
		this.customerEmail = cusEmail;
		
		this.address1 = cusAddr1;
		this.address2 = cusAddr2;
		this.accounts = getCustomerSavings(cusDt);
		this.transactionStatusCode = statusCode;
		this.transactionStatusDescription = statusDesc;
		
	} 
	
	
	public Long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
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
	public int getTransactionStatusCode() {
		return transactionStatusCode;
	}
	public void setTransactionStatusCode(int transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}
	public String getTransactionStatusDescription() {
		return transactionStatusDescription;
	}
	public void setTransactionStatusDescription(String transactionStatusDescription) {
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	
	
	
    public List<Map<String, Object>> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Map<String, Object>> accounts) {
		this.accounts = accounts;
	}

	public  List<Map<String, Object>> getCustomerSavings(List<AccountEntity> data) {
        // Wrap in a List
        List<Map<String, Object>> datalist = new ArrayList<>();

        if(data.isEmpty()) {            
        	return (List<Map<String, Object>>) datalist;
        }
        String accTypeDesc = (data.get(0).getAccountType().toUpperCase().equals("S") ? "Savings" : "Checking");
    	for(AccountEntity dt: data) {
            // Create a savings account entry
    		
            Map<String, Object> savingsAccount = new HashMap<>();
            savingsAccount.put("accountNumber", dt.getAccountNumber());
            savingsAccount.put("accountType", accTypeDesc);
            savingsAccount.put("availableBalance", dt.getAvailableBalance());
            datalist.add(savingsAccount);    		
    	}
    	
        return datalist;
    }
	
}
