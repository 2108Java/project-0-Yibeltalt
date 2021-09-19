package com.bank.models;
import java.sql.Date;
public interface DoAccount {
				
				
		public String toString() ;
		public int getAccountid(); 
			
		public void setAccountid(int accountid); 
			
		public String getAccountname() ;
		
		public void setAccountname(String accountname); 
			
		public double getBalance() ;
			
		public void setBalance(double balance) ;
			
		public int getCusid() ;
	
		public void setCusid(int cusid) ;
		
		public int getAcctypeid(); 

		public void setAcctypeid(int acctypeid); 

		public Date getDatecreated(); 

		public void setDatecreated(Date datecreated) ;
				

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

