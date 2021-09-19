package com.bank.models;

import java.sql.Date;
public class Account implements DoAccount {
			
			private int accountid;
			private String accountname;
			private double balance ;
			private int cusid ;
			private int acctypeid;
			private Date datecreated;
			private int cusid2;
		
			public Account(int accountid, String accountname, double balance, int cusid, int acctypeid,
					Date datecreated) {
				super();
				this.accountid = accountid;
				this.accountname = accountname;
				this.balance = balance;
				this.cusid = cusid;
				this.acctypeid = acctypeid;
				this.datecreated = datecreated;
			}
			public Account(int accountid,String accountname, double balance, int cusid, int acctypeid) {
				super();
				this.accountid = accountid;
				this.accountname = accountname;
				this.balance = balance;
				this.cusid = cusid;
				this.acctypeid = acctypeid;
				
			}

			public Account(int accountid2, String accountname2, double balance2, int custid, int acctypeid2,
					int custid2) {super();
					this.accountid = accountid2;
					this.accountname = accountname2;
					this.balance = balance2;
					this.cusid = custid;
					this.acctypeid = acctypeid2;
					this.cusid2 =custid2;
					
				// TODO Auto-generated constructor stub
			}
			@Override
			public String toString() {
				return "Account [accountid=" + accountid + ", accountname=" + accountname + ", balance=" + balance
						+ ", cusid=" + cusid + ", acctypeid=" + acctypeid + ", datecreated=" + datecreated + "]";
			}

			public int getAccountid() {
				return accountid;
			}

			public void setAccountid(int accountid) {
				this.accountid = accountid;
			}

			public String getAccountname() {
				return accountname;
			}

			public void setAccountname(String accountname) {
				this.accountname = accountname;
			}

			public double getBalance() {
				return balance;
			}

			public void setBalance(double balance) {
				this.balance = balance;
			}

			public int getCusid() {
				return cusid;
			}

			public void setCusid(int cusid) {
				this.cusid = cusid;
			}
			public int getCusid2() {
				return cusid2;
			}

			public void setCusid2(int cusid2) {
				this.cusid2 = cusid2;
			}

			public int getAcctypeid() {
				return acctypeid;
			}

			public void setAcctypeid(int acctypeid) {
				this.acctypeid = acctypeid;
			}

			public Date getDatecreated() {
				return datecreated;
			}

			public void setDatecreated(Date datecreated) {
				this.datecreated = datecreated;
			}
			
			

	
}
