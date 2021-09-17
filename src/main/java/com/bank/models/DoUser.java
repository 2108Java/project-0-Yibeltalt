package com.bank.models;

public interface DoUser {
	public int getUserId(); 
	
	public void setUserId(int id); 
		
	public String getFname(); 
		
	public void setFname(String fname); 
		
	public String getLname(); 
		
	public void setLname(String lname) ;
	
	public String getuserName(); 
		
	public void setUserName(String lname) ;
		
	public String getPassword();
		
	public void setPassword(String password); 
	
	public int getUserTypeID();
	
	public void setUserType(int usertypeid);
		
}
