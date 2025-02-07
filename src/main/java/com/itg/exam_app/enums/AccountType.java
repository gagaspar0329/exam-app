package com.itg.exam_app.enums;

public enum AccountType {
	S,C;
	
    public String getCustomValue() {
        switch (this) {
            case S:
                return "Savings";
            case C:
                return "Checking";
            default:
                return null;
        }
    }
}
