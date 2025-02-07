package com.itg.exam_app.response.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itg.exam_app.commons.HTTPStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	HTTPStatus httpStatus;
	
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorResponse> handleCommonException(CommonException ex) {
    	String errorType = ex.getErrorType();
    	int errorCode = 0;
        String errorMessage = "";
        
        if ("invalidEmail".equals(errorType)) {
        	errorCode = httpStatus.CUSTOM_ERR_CODE_INVALID_EMAIL;
        	errorMessage = httpStatus.CUSTOM_ERR_MSG_INVALID_EMAIL;
        }  
        if ("missingEmail".equals(errorType)) {
        	errorCode = httpStatus.CUSTOM_ERR_CODE_MISSING_EMAIL;
        	errorMessage = httpStatus.CUSTOM_ERR_MSG_MISSING_EMAIL;          
        } 
        if ("customerNotFound".equals(errorType)) {
        	errorCode = httpStatus.CUSTOM_ERR_CODE_CUS_NOTFOUND;  
        	errorMessage = httpStatus.CUSTOM_ERR_MSG_CUS_NOTFOUND;    
        	return ((BodyBuilder) ResponseEntity.status(401)).body(new ErrorResponse(errorCode,errorMessage));
        }

        return ResponseEntity.badRequest().body(new ErrorResponse(errorCode,errorMessage));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
    	return ResponseEntity.internalServerError().body(new ErrorResponse(httpStatus.HTTP_ERR_CODE_INT_SRV_ERR,httpStatus.HTTP_ERR_MSG_INT_SRV_ERR));
    }
}