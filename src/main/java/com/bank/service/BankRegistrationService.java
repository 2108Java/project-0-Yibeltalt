package com.bank.service;
import com.bank.database.DataImp;
import com.bank.models.Customer;
import com.bank.models.User;

public class BankRegistrationService {
	
			DataImp database;
		

		public boolean registercustomer(Customer newcust) {
			// TODO Auto-generated method stub
			return database.registercustomer(newcust);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	


