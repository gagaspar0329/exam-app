package com.itg.exam_app.commons;

import org.springframework.stereotype.Component;

@Component
public class HTTPStatus {
	
	public final int CUSTOM_SUC_CODE_CREATION = 201;
	public final String CUSTOM_SUC_MSG_CREATION = "Customer account created";
	
	public final int CUSTOM_ERR_CODE_MISSING_EMAIL = 400;
	public final String CUSTOM_ERR_MSG_MISSING_EMAIL = "Email is required field";
	
	public final int CUSTOM_ERR_CODE_INVALID_EMAIL = 400;
	public final String CUSTOM_ERR_MSG_INVALID_EMAIL = "Invalid Email Format";
	
	
	public final int CUSTOM_SUC_CODE_SEARCH = 302;
	public final String CUSTOM_SUC_MSG_SEARCH = "Customer account found";
	
	public final int CUSTOM_ERR_CODE_CUS_NOTFOUND = 401;
	public final String CUSTOM_ERR_MSG_CUS_NOTFOUND = "Customer not found";
	
	
	public final int HTTP_ERR_CODE_INT_SRV_ERR = 500;
	public final String HTTP_ERR_MSG_INT_SRV_ERR = "Internal Service Error";
	

	


}
