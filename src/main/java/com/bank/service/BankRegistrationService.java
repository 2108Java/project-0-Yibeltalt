package com.bank.service;
import com.bank.database.DataImp;
import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.models.Genetateid;


public class BankRegistrationService {
	
		DataImp database;

		public BankRegistrationService(DataImp database2) {
			// TODO Auto-generated constructor stub
			
			this.database = database2;
		}

		public boolean registercustomer(Customer newcust) {
			// TODO Auto-generated method stub
			return database.registercustomer(newcust);
		}

		public boolean registeraccount(Account newaccount,int usertype) {
			// TODO Auto-generated method stub
			return database.registerAccount(newaccount,usertype);
		}
		public boolean registeraccount2(Account newaccount) {
			// TODO Auto-generated method stub
			return database.registerAccount2(newaccount);
		}
//		public boolean registeraccount3(Account newaccount) {
//			// TODO Auto-generated method stub
//			return database.registerAccount3(newaccount);
//		}
//		
		public  Genetateid getnewid() {
			// TODO Auto-generated method stub
			return database.getnewid();
		}
//		public void updateid(Genetateid gid) {
//			// TODO Auto-generated method stub
//			return database.Upnewid(gid);
//		}
//		
		public  boolean Authauthorizeaccount(int accountid) {
			// TODO Auto-generated method stub
			return database.Authauthorizeaccount(accountid);
		}
		
		public  double balanceofmyaccount(int cusid,String idenum) {
			// TODO Auto-generated method stub
			return database.balanceofmyaccount(cusid,idenum);
		}
		
		
//		public boolean registercustomer(Customer newcust) {
//			// TODO Auto-generated method stub
//			return database.registercustomer(newcust);
//		}
//		
	}
	
	
	
	
	
	
	
	
	
	
	
	


