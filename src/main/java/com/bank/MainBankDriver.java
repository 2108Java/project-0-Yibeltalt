package com.bank;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bank.database.DataImp;
import com.bank.menu.Menu;
import com.bank.service.AuthenticationService;
import com.bank.service.BankRegistrationService;
import com.bank.service.TransactionProcessindServ;





public class MainBankDriver {
	
    public final static Logger loggy = Logger.getLogger(MainBankDriver.class);
	
	public static void main(String[] args) {

		loggy.setLevel(Level.WARN);
		
		loggy.info("Starting the application");
		
		DataImp database = new DataImp();
		
		AuthenticationService service = new AuthenticationService(database);
		
		BankRegistrationService service1 =new BankRegistrationService(database);
		
		TransactionProcessindServ service2 =new TransactionProcessindServ(database);
		
		Menu mainMenu = new Menu(service,service1,service2);
		
		mainMenu.display();
		
	}

}
