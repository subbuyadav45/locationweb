package com.subbu.location.util;

public interface EmailUtil {
	void sendEmail(String toAddress, String subject, String body);

	/*Utility layer:: It will carry all that code which is common across the app, and also which perfom's a special operation */
	
	/*1) add spring mail dependency   -->starter-mail
	 * 2)code the utility layer
	 * 3)Configure spring boot properties*/
	
}
