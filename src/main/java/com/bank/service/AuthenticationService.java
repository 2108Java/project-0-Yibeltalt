package com.bank.service;

import com.bank.database.DataImp;


public class AuthenticationService {

	DataImp database;
	
	public AuthenticationService(DataImp database) {
		this.database = database;
	}

	
	public boolean validate(String username) {
			//check if user exists
			return true;
	}
		
	public int authenticate(String username, String password) { //verify that they are the user
			
		return database.userAutenticate(username,password);
	}
	
	
}