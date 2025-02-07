package com.itg.exam_app.response.success;

public class CreateModel {
	
	private Long customerNumber;
	private int transactionStatusCode;
	private String transactionStatusDescription;
	
	public CreateModel(Long customerNumber, int statusCode, String statusDesc) {
		this.customerNumber = customerNumber;
		this.transactionStatusCode = statusCode;
		this.transactionStatusDescription = statusDesc;
		
	} 
	
	public Long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
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
	
	
}
