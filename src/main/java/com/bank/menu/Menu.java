package com.bank.menu;
import java.sql.Date;
import java.util.Scanner;

import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.models.Genetateid;
import com.bank.models.User;
import com.bank.service.AuthenticationService;
import com.bank.service.BankRegistrationService;


public class Menu {

	AuthenticationService sr;
	BankRegistrationService sr1;
	public Menu(AuthenticationService sr,BankRegistrationService sr1) {
		this.sr = sr;
		this.sr1 = sr1;
	}
	

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
		  System.out.println("2) Balance");
		  System.out.println("3) Withdrawal or deposit");
		  System.out.println("4) Transfer to another account"); 
		  System.out.println("5) Exit");
		 
	}
	private void userMenu() {

		
		  System.out.println("1) Register for a customer account");
		  System.out.println("2) Apply for joint account"); 
		  System.out.println("3) Exit");
		 
	}
	
	
	private void registorcustomeraccout(boolean joint) {
		
		int acctypeid=0;
	
		System.out.println("Create Customer sub menu");
		Genetateid gin = sr1.getnewid();
		Genetateid gin2 = sr1.getnewid();
		if(!joint) {
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
			if(sr1.registercustomer(newcust)&&sr1.registeraccount(accnew)) {
				System.out.println("Successfully added!");
			}else {
				System.out.println("not added!");
			}
			}
		
		else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Joint Account Name");
			String accountname2 = sc.nextLine();
			int custid = gin.getCustomerid();
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
			System.out.println("Enter customer 2 information");
			int custid2 = gin2.getCustomerid();
			int accountid2 =gin2.getAccountid();
			System.out.println("First Name");
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
	
	
	
	
	

	public void display() {

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

		
		
			int res = sr.authenticate(username, password);

			if (res == 100) {
				System.out.println("Adminstrator Main Menu");
				adminMenu();
//			System.out.println("Noooosssssssssssssss");
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
				System.out.println("Employee Main Menu");
				empMenu();
						} 
			else if (res == 102) {
				System.out.println("Customer Main Menu");
				customerMenu();
			}
			else if (res == 103) {
					System.out.println("User Main Menu");
					userMenu();
					String result = scanner.nextLine();
					switch (result)
					{
					case "1":
						registorcustomeraccout(false);
						break;
					case  "2":
						registorcustomeraccout(true);
						break;
					case "3":
						running =false;
						System.out.println("Thanks for using our application ");
						running = false;
						break;
					default:
						System.out.println("last Menu");
					}
				   } 
			else 
				System.out.println("Invalid Username or Password ");
			
		}while (running);
		
		}
	}

