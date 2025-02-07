package com.itg.exam_app.commons;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class FieldValidations {
	
	private static final String REGEX_PATTERN_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(REGEX_PATTERN_EMAIL);	        
	
        
    public boolean isValidEmail(String email) {
    	if(email != null && !email.isEmpty() && EMAIL_PATTERN.matcher(email).matches()) {
    		return true;
    	}
    	return false;
    }
	
}
