package com.bank;

import com.bank.database.DataImp;
import com.bank.menu.Menu;
import com.bank.service.AuthenticationService;
import com.bank.service.BankRegistrationService;

public class MainBankDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataImp database = new DataImp();
		
		AuthenticationService service = new AuthenticationService(database);
		
		BankRegistrationService service1 =new BankRegistrationService(database);
		
		Menu mainMenu = new Menu(service,service1);
		
		mainMenu.display();
		
	}

}
