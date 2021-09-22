package com.bank.service;

import com.bank.database.DataImp;

import com.bank.models.Transaction;

public class TransactionProcessindServ {
DataImp database;

	public TransactionProcessindServ(DataImp database) {
		// TODO Auto-generated constructor stub
		
		this.database = database;
	}
	
//	public boolean withdrawaldeposit(Transaction tra,double balance) {
//		// TODO Auto-generated method stub
//		return database.withdrawal(tra,balance);
//	}
	public boolean withdrawal(Transaction tra,double balance) {
		// TODO Auto-generated method stub
		return database.withdrawal(tra,balance);
	}
	public boolean deposit(Transaction tra,double balance) {
		// TODO Auto-generated method stub
		return database.deposit(tra,balance);
	}
	public int Transactioncheck(int cusid,String idenum,double amount) {
		
		return database.Transactioncheck(cusid,idenum, amount);
   }
	public int Transactioncheck2(int cusid,double amount) {
		
		return database.Transactioncheck2(cusid, amount);
   }
	
	
	public boolean transferotherAccount(Transaction tra, double balance1,double balance2) {
		
		return database.transferotherAccount(tra,balance1,balance2);
   }

	public Transaction [] displaytrans() {
		
		return database.displaytrans();
   }

	
	
	
	;
	
}
