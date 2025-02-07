package com.itg.exam_app.response.error;

public class ErrorResponse {

	private int transactionStatusCode;
	private String transactionStatusDescription;
	
	public ErrorResponse(int transactionStatusCode, String transactionStatusDescription) {
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
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
