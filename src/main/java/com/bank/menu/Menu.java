package com.bank.menu;

import java.util.Scanner;

import com.bank.service.AuthenticationService;

public class Menu {

	AuthenticationService sr;

	public Menu(AuthenticationService sr) {
		this.sr = sr;
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

	public void display() {

		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		System.out.println("Welcome to Our Bank");
		System.out.println("Username");
		String username = scanner.nextLine();
		System.out.println("Password");
		String password = scanner.nextLine();

		while (running) {
		
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
				System.out.println("User Main Menu");
				customerMenu();
						} 
			else 
				System.out.println("User not found");
					

			
			/*
			 * System.out.println("Noooosssssssssssssss"); if (result.equals(1) && res ==
			 * 100) { System.out.println ("admin 1st menu"); } else System.out.println
			 * ("other");
			 */
			
			
			/*
			 * switch (result) { case "1": User[] user = sr.getAllUser();
			 * prettyDisplayOfArray(user); break; case "2": System.out.println("UserId:");
			 * String userId = scanner.nextLine(); System.out.println("First Name"); String
			 * fName = scanner.nextLine(); System.out.println("Last Name:"); String lName =
			 * scanner.nextLine(); System.out.println("Password"); String password =
			 * scanner.nextLine(); user newUser = new user(userId, fName, lName, password);
			 * 
			 * if (sr.addUser(newUser)) { System.out.println("Successfully added!"); } else
			 * { System.out.println("not added!"); }
			 * 
			 * break;
			 * 
			 * case "3": System.out.println("Enter User ID to Search"); String usersearch =
			 * scanner.nextLine(); user[] searcheduser = sr.getUserByid(usersearch);
			 * prettyDisplayOfArray(searcheduser); break;
			 * 
			 * case "4": System.out.println("Enter User ID to delete "); String userdelete =
			 * scanner.nextLine(); if (sr.delUserByid(userdelete)) {
			 * System.out.println("Successfully deleted!"); } else {
			 * System.out.println("not deleted!"); }
			 * 
			 * break;
			 * 
			 * case "5": System.out.println("Thanks for using our application "); running =
			 * false; System.exit(0); break; // default: //
			 * System.out.println("That's not a valid input!"); //
			 * System.out.println("Try again!");
			 * 
			 * }
			 */

		}

	}

}
