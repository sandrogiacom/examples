package com.fluig.junit5.demo;

public class PasswordValidator {

	// rules:
	// pass must be between 8 and 12 chars
	// must not have spaces
	// must have both upper and lower case letters
	// must include one of these chars: #$%ˆ&*
	// must include a number
	// must start with a letter
	public boolean validate(String pwd) {
		return validateSize(pwd);
	}

	boolean validateSize(String pwd) {
		return pwd != null && pwd.length() >= 8 && pwd.length() <= 12;
	}

	boolean hasSpaces(String pwd) {
		return pwd != null && pwd.contains(" ");
	}

	boolean hasUppercaseChars(String pwd) {
		return pwd != null && pwd.matches("\\.[AZ]\\.");
	}

	boolean hasLowercaseChars(String pwd) {
		return pwd != null && pwd.matches("\\.[az]\\.");
	}

	boolean includesSpecialChars(String pwd) {
		return pwd != null && pwd.matches("\\.[#$%ˆ&*]\\.");
	}

	boolean includesNumber(String pwd) {
		return pwd != null && pwd.matches("\\.[0..9]\\.");
	}

	boolean startsWithChar(String pwd) {
		return pwd != null && Character.isLetter(pwd.charAt(0));
	}

}
