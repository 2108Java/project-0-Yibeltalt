package com.bank.models;

public class Genetateid {
	
	
	   private int customerid;
	   private int accountid;
	   private boolean isnew;
	   
	public Genetateid(int customerid, int accountid, boolean isnew) {
		
		this.customerid = customerid;
		this.accountid = accountid;
		this.isnew = isnew;
	}
	public Genetateid() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public boolean isIsnew() {
		return isnew;
	}
	public void setIsnew(boolean isnew) {
		this.isnew = isnew;
	}
	   
}
