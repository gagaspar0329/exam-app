package com.itg.exam_app.controller;

import java.rmi.ServerException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itg.exam_app.commons.FieldValidations;
import com.itg.exam_app.commons.HTTPStatus;
import com.itg.exam_app.entity.AccountEntity;
import com.itg.exam_app.entity.CustomerEntity;
import com.itg.exam_app.response.error.CommonException;
import com.itg.exam_app.response.success.CreateModel;
import com.itg.exam_app.response.success.SearchModel;
import com.itg.exam_app.services.AccountService;
import com.itg.exam_app.services.CustomerService;



@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HTTPStatus httpStatus;
	
	@Autowired
	private FieldValidations fieldValidations;
	
	private final String ATT_CUS_NUMBER = "customerNumber";
	private final String ATT_CUST_NAME = "customerName";
	private final String ATT_CUS_MOBILE = "customerMobile";
	private final String ATT_CUS_EMAIL = "customerEmail";
	private final String ATT_ADDR1 = "address1";
	private final String ATT_ADDR2 = "address2";
	private final String ATT_SAVINGS = "savings";
	private final String ATT_CHECKING = "Checking";
	private final String ATT_TRANS_CODE = "transactionStatusCode";
	private final String ATT_TRANS_DESC = "transactionStatusDescription";
	
	
	

	//#1.	Account creation service 
	@PostMapping(path="/customer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateModel> createAccount(@RequestBody CustomerEntity newCustomer, HttpServletRequest request) throws ServerException {
		
		if(newCustomer.getCustomerEmail() == null || newCustomer.getCustomerEmail().isEmpty()){
			throw new CommonException("missingEmail",httpStatus.CUSTOM_ERR_MSG_MISSING_EMAIL);
		}		
		if(!fieldValidations.isValidEmail(newCustomer.getCustomerEmail())){
			throw new CommonException("invalidEmail",httpStatus.CUSTOM_ERR_MSG_INVALID_EMAIL);
		}
		
		CustomerEntity customerData = customerService.createAccount(newCustomer);
		if (customerData != null) {
			CreateModel response = new CreateModel(
					customerData.getId()
					,httpStatus.CUSTOM_SUC_CODE_CREATION
					,httpStatus.CUSTOM_SUC_MSG_CREATION
			);
		    return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}else {
			throw new CommonException("customError", "Something went wrong in the custom process!");
		}
		
	}
	
	//#2 Customer inquiry service 
	@GetMapping("/account/{customerNumber}")
	public ResponseEntity<Map<String, Object>>  getCustomerByCustomerNumber(@PathVariable Long customerNumber) {
		Optional<CustomerEntity> customerData = customerService.getCustomerByCustomerNumber(customerNumber);
		 Map<String, Object> response = new LinkedHashMap<>();
		if(customerData.isPresent()) {
			CustomerEntity ceData = customerData.get();
			   Long cusId = 0L; // Default value
			   cusId = ceData.getId();
			  List<AccountEntity> cusAccounts = accountService.findByCustomNumberAndAccountType(ceData.getId(), ceData.getAccountType());
			 SearchModel dataModel = new SearchModel(
					 cusId,  ceData.getCustomerName(),ceData.getCustomerMobile(),ceData.getCustomerEmail(), ceData.getAddress1(), ceData.getAddress2(),ceData.getAccountType()
					 ,httpStatus.CUSTOM_SUC_CODE_SEARCH
					 ,httpStatus.CUSTOM_SUC_MSG_SEARCH,cusAccounts
			 );
			 response.put(ATT_CUS_NUMBER, dataModel.getCustomerNumber());
			 response.put(ATT_CUST_NAME, dataModel.getCustomerName());
			 response.put(ATT_CUS_MOBILE, dataModel.getCustomerMobile());
			 response.put(ATT_CUS_EMAIL, dataModel.getCustomerEmail());
			 response.put(ATT_ADDR1, dataModel.getAddress1());
			 response.put(ATT_ADDR2, dataModel.getAddress2());
			 if(ceData.getAccountType().equals("S")) {
				 response.put(ATT_SAVINGS, dataModel.getAccounts()); 
			 }else {
				 response.put(ATT_CHECKING, dataModel.getAccounts()); 
			 }			 
			 response.put(ATT_TRANS_CODE, dataModel.getTransactionStatusCode());
			 response.put(ATT_TRANS_DESC, dataModel.getTransactionStatusDescription());
//			 return ResponseEntity.status(HttpStatus.OK)..body(response);
			 return ResponseEntity.status(HttpStatus.FOUND).body(response);
		}else {
			throw new CommonException("customerNotFound", "customerNotFound");
		}	
	}
	
	
	@GetMapping("/getAllCustomers")
	public Iterable<CustomerEntity>  getAllCustomers() {
		return customerService.getAllAccounts();
	}
	
}
