package com.bank.menu;
import java.sql.Date;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.models.Genetateid;
import com.bank.models.Transaction;
import com.bank.models.User;
import com.bank.service.AuthenticationService;
import com.bank.service.BankRegistrationService;
import com.bank.service.TransactionProcessindServ;



public class Menu {

	AuthenticationService sr;
	BankRegistrationService sr1;
	TransactionProcessindServ sr2;
	public Menu(AuthenticationService sr,BankRegistrationService sr1,TransactionProcessindServ sr2) {
		this.sr = sr;
		this.sr1 = sr1;
		this.sr2 = sr2;
	}
	
	private static final Logger loggy = Logger.getLogger(Menu.class);
	/*
	 * private void prettyDisplayOfArray(DoUser[] user) {
	 * 
	 * for (int i = 0; i < user.length; i++) {
	 * 
	 * if (user[i] != null) { System.out.println(user[i].getId());
	 * System.out.println(user[i].getfname());
	 * System.out.println(user[i].getlname());
	 * System.out.println(user[i].getpassword()); System.out.println("");
	 * 
	 * }
	 * 
	 * } }
	 */

	private void adminMenu() {

		
		  System.out.println("1) Register for a customer account");
		  System.out.println("2) Approve or reject an account registration");
		  System.out.println("3) View a customer's bank accounts");
		  System.out.println("4) view a log of all transactions");
		  System.out.println("5) Balance");
		  System.out.println("6) Withdrawal or deposit");
		  System.out.println("7) Transfer to another account"); 
		  System.out.println("8) Exit");
		 
	}
	private void empMenu() {

		
		  System.out.println("1) Register for a customer account");
		  System.out.println("2) Approve or reject an account registration");
		  System.out.println("3) View a customer's bank accounts");
		  System.out.println("4) view a log of all transactions"); 
		  
		  System.out.println("5) Exit");
		 
	}
	private void customerMenu() {

		
		  System.out.println("1) Register for a customer account");
		  System.out.println("2) balance of a specific account");
		  System.out.println("3) Withdrawal or deposit");
		  System.out.println("4) Transfer to another account"); 
		  System.out.println("5) Exit");
		 
	}
	private void userMenu() {

		
		  System.out.println("1) Register for a customer account");
		  System.out.println("2) Apply for joint account"); 
		  System.out.println("3) Exit");
		 
	}
	
	
	private void registorcustomeraccout(boolean joint,int userid) {
		
		int acctypeid=0;
	
		
		Genetateid gin = sr1.getnewid();
		//Genetateid gin2 = sr1.getnewid();
		if(!joint) {
			System.out.println(" Customer Account Registration");
			Scanner sc = new Scanner(System.in);
			int custid = gin.getCustomerid();
			int accountid =gin.getAccountid();
			System.out.println("Account type saving /S/ " + "or"+ "cheking /C/");
			String str =  sc.nextLine();
			System.out.println("First Name");
			String fname = sc.nextLine();
			System.out.println("Last Name");
			String lname = sc.nextLine();
			System.out.println("Street");
			String street = sc.nextLine();
			System.out.println("Email");
			String email = sc.nextLine();
			System.out.println("identityno");
			String identityno = sc.nextLine();
			System.out.println("Zipcode");
			int zipcode = sc.nextInt();	
			System.out.println("CellPhone");
			long cellno = sc.nextLong();	
			System.out.println("Balance");
			double balance = sc.nextDouble();
			if (str.equals ("s") || str.equals("S") ) {
			     acctypeid = 2;
			}else {
				 acctypeid = 1;
			}
		
			String accountname = fname;
			Customer newcust = new Customer(custid,fname,lname,street,zipcode,cellno,email,identityno);
			Account accnew = new Account(accountid,accountname,balance,custid,acctypeid);
			if(sr1.registercustomer(newcust)&&sr1.registeraccount(accnew,userid)) {
				System.out.println("Successfully added!");
			}else {
				System.out.println("not added!");
			}
			}
		
		else {
			System.out.println(" Joint Customer Account Registration");
			Scanner sc = new Scanner(System.in);
			System.out.println("Joint Account Name");
			String accountname2 = sc.nextLine();
			int custid = gin.getCustomerid();
			Genetateid gin2 = sr1.getnewid();
			System.out.println("Account type saving /S/ " + "or"+ "  cheking /C/");
			String str =  sc.nextLine();
			System.out.println("First Name");
			String fname = sc.nextLine();
			System.out.println("Last Name");
			String lname = sc.nextLine();
			System.out.println("Street");
			String street = sc.nextLine();
			System.out.println("Email");
			String email = sc.nextLine();
			System.out.println("identityno");
			String identityno = sc.nextLine();
			System.out.println("Zipcode");
			int zipcode = sc.nextInt();	
			System.out.println("CellPhone");
			long cellno = sc.nextLong();
			int custid2 = gin2.getCustomerid();
			int accountid2 =gin2.getAccountid();
			
			System.out.println("Secound customer information");
			System.out.println("   ");
			System.out.println("First Name");
			sc.nextLine();
			String fname2 = sc.nextLine();
			System.out.println("Last Name");
			String lname2 = sc.nextLine();
			System.out.println("Street");
			String street2 = sc.nextLine();
			System.out.println("Email");
			String email2 = sc.nextLine();
			System.out.println("identityno");
			String identityno2 = sc.nextLine();
			System.out.println("Zipcode");
			int zipcode2 = sc.nextInt();	
			System.out.println("CellPhone");
			long cellno2 = sc.nextLong();
			
			System.out.println("Balance");
			double balance = sc.nextDouble();
			if (str.equals ("s") || str.equals("S") ) {
			     acctypeid = 2;
			}
			else {
				 acctypeid = 1;
			}
			
			Customer newcust = new Customer(custid,fname,lname,street,zipcode,cellno,email,identityno);
			Customer newcust3 = new Customer(custid2,fname2,lname2,street2,zipcode2,cellno2,email2,identityno2);
			Account accnew1 = new Account(accountid2,accountname2,balance,custid,acctypeid,custid2);
			
			
			if(sr1.registercustomer(newcust)&&sr1.registeraccount2(accnew1)&&sr1.registercustomer(newcust3)) {
				System.out.println("Successfully added!");
			}else {
				System.out.println("not added!");
			}
			
			
			
			
			
			
		}
		
	}
	
	
	public void balanceofmyaccount() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the customer id");
		int cusid= sc2.nextInt();
		System.out.println("identityno");
		sc2.nextLine();
		String idenum= sc2.nextLine();
		Double res=sr1.balanceofmyaccount(cusid,idenum);
		if(res!= 0.0) {
			System.out.println("Your current Account Balance is  :"+"   "+res);
		}else {
			System.out.println("Customer id  or Identityno not correct!");
		}
		
		
	}
	
	
	public void withdrawaldeposit() {
		
		boolean with =false;
		boolean dep =false;
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the customer id");
		int cusid= sc2.nextInt();
		System.out.println("identityno");
		sc2.nextLine();
		String idenum= sc2.nextLine();
		System.out.println("withdrawal /W/ " + "or"+ " deposit /D/");
		String transtype= sc2.nextLine();
		System.out.println("Amount");
		double amount= sc2.nextDouble();
		System.out.println("text message");
		sc2.nextLine();
		String mess= sc2.nextLine();
		
		
		int tranid,db_acc,cr_acc;
		int result3 = sr2.Transactioncheck(cusid,idenum,amount);
		
		if (result3==1)
		{
			System.out.println(" Invalid transaction ! withdrawal that would result in a negative balance."+"\n");
		}
		else if (result3==2)
		{
			System.out.println(" Invalid transaction ! deposit or withdrawal of negative money."+"\n");

		}
		else {
		
		
		Double balance =sr1.balanceofmyaccount(cusid,idenum);
		
		
		if (transtype.equals("w") ||transtype.equals("W"))
		{
		 tranid = 1;
		 db_acc= 9999999;
		 Transaction tra = new Transaction (result3,db_acc,amount,mess,tranid);
		 		with=sr2.withdrawal(tra,balance);

		}
		else if (transtype.equals("d") ||transtype.equals("D"))
			{
			tranid = 2;
			cr_acc=9999999;
			int result2 = sr2.Transactioncheck(cusid,idenum,amount);
			System.out.println("************"+result3);
			Transaction tra = new Transaction (cr_acc,result2,amount,mess,tranid);
				dep=sr2.deposit(tra,balance);
		}
		else 
			System.out.println("Invalid Transaction selected!!");

		}
		
		if ((with==true)||(dep==true))
		{
			System.out.println("************"+result3);
			System.out.println ("Transaction completed successfully !!)"+"\n");
			
		}
		else 
		{
			System.out.println ("Transaction not updated !!)"+"\n");
		}
		
	}
		
	public void transferotherAccount() {
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Enter the customer id");
		int cusid= sc3.nextInt();
		System.out.println("identityno");
		sc3.nextLine();
		String idenum= sc3.nextLine();
		System.out.println("Enter the customer id 2");
		int cusid2= sc3.nextInt();
		System.out.println("Amount");
		double amount= sc3.nextDouble();
		System.out.println("text message");
		String messg= sc3.nextLine();
		int accno1 = sr2.Transactioncheck(cusid,idenum,amount);
		int accno2 = sr2.Transactioncheck(cusid2,"emp",amount);
		
		System.out.println("##############################"+accno1);
		
		System.out.println("##############################"+accno2);
		
		
		Transaction tra = new Transaction (accno1,accno2,amount,messg,3);
		Double balance1 =sr1.balanceofmyaccount(cusid,idenum);
		Double balance2= sr1.balanceofmyaccount(cusid2,idenum);
		System.out.println("##############################"+balance1);
		System.out.println("##############################"+balance1);
		if (sr2.transferotherAccount(tra,balance1,balance2))
			System.out.println("Transfer balance successfuly completed ");
		else 
			System.out.println("Transfer balance Not succssfull ");
		
	}
	
	

	public void display() {
		
		loggy.setLevel(Level.ALL);
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		System.out.println("Welcome to Bank");
		
		System.out.println("Are you a new user (Y/N)?"+"\n");
		String ch = scanner.nextLine();
		if (ch.equals("Y") || ch.equals("y")) {
			System.out.println("User Registration");
			System.out.println("First Name");
			String fname = scanner.nextLine();
			System.out.println("Last Name");
			String lname = scanner.nextLine();
			System.out.println("User Name");
			String username = scanner.nextLine();
			System.out.println("Password");
			String password = scanner.nextLine();
			User newUser = new User(fname,lname,username,password,103);
     
			if(sr.registerUser(newUser)) {
				System.out.println("User Successfully added!");
				
			}else {
				System.out.println("not added!");
			}
			
		}
		running = true;
		do {
			System.out.println("----------------Login Menu-------------- ");
			System.out.println("Username");
			String username = scanner.nextLine();
			System.out.println("Password");
			String password = scanner.nextLine();
			System.out.println("--------------------------------------- ");

			
			loggy.setLevel(Level.WARN);
			int res = sr.authenticate(username, password);
			loggy.info("User put in the option :" + res);
			
			loggy.setLevel(Level.WARN);

			if (res == 100) {
				
				loggy.info("User selected Admin menu");
				
				System.out.println("Adminstrator Main Menu");
				adminMenu();

				String result = scanner.nextLine();
				switch (result)
				{
				case "1":
					System.out.println("the first menu");
				default:
					System.out.println("last Menu");
				}
			   } 
			else if (res == 101) {
				loggy.info("User selected Employee menu");
				System.out.println("Employee Main Menu");
				empMenu();
						} 
			else if (res == 102) {//customer menu
				loggy.info("User selected Customer menu");
				
				boolean runningin = true;
				 do {
					 System.out.println("Customer Main Menu");
					 customerMenu();
					 String result = scanner.nextLine();
						switch (result)
						{
						case "1":
							registorcustomeraccout(false,res);
							break;
							
						case "2":
							balanceofmyaccount();
							break;
						case "3":
							withdrawaldeposit();
							break;
						case "4":
							transferotherAccount();
							break;
						case "5":
						//	running =false;
						//	System.out.println("Thanks for using our application ");
							runningin = false;
							//running = false;
							break;
						default:
							System.out.println("last Menu");
							
						}
				 }while (runningin);
						
			}
			else if (res == 103) { //user menu 
				loggy.info("User selected User menu");
				boolean runningin = true;
				 do {
					System.out.println("User Main Menu");
					userMenu();
					String result = scanner.nextLine();
					switch (result)
					{
					case "1":
						registorcustomeraccout(false,res);
						break;
					case  "2":  
						registorcustomeraccout(true,res);
						break;
					case "3":
						running =false;
						System.out.println("Thanks for using our application ");
						runningin = false;
						//running = false;
						break;
					default:
						System.out.println("last Menu");
					}
				 }while (runningin);
				   } 
			else 
				System.out.println("Invalid Username or Password ");
			
		}while (running);
		
		}
	
	}

