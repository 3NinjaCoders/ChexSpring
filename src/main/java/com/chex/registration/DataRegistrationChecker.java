package com.chex.registration;

public class DataRegistrationChecker {
	public boolean check_password_size(String password) {
		return password.length() > 5 ? true : false;
	}
	
	public boolean check_password_alfdig(String password) {
		char letters[] = password.toCharArray();
		boolean hasLetter = false, hasNumber = false;
		for(char c : letters) {
			if(c >= 65 && c <=122) {
				hasLetter = true;
				break;
			}
		}
		
		for(char c: letters) {
			if(c >= 48 && c<= 57) {
				hasNumber = true;
				break;
			}
		}
		
		if(hasNumber == true && hasLetter == true)
			return true;
		return false;		
	}
	
	public boolean check_firstname(String firstname) {
		return !(firstname.isBlank() || firstname == null); 
	}
	
	public boolean check_lastname(String firstname) {
		return !(firstname.isBlank() || firstname == null); 
	}
	
	public boolean check_login(String login) {
		return !(login.isBlank() || login == null); 
	}
	
	public boolean check_two_passord(String pass1, String pass2) {
		return pass1.equals(pass2);
	}
}
