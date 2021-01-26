package com.test.jee;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		
		if ( user.equalsIgnoreCase("paola") && password.equals("1234567"))
			return true;
		
		return false;
	}
}
