package com.bank.models;

public class Customer implements DoCustomer{
		
		private int customerid;
		private String fname;
		private String lname;
		private String street ;
		private int zipcode ;
		private long cellno ;
		private String email ;
		private String identityno;
		
		public Customer(int customerid,String fname,String lname,String street ,int zipcode ,long cellno ,String email,String identityno) {
			
		this.customerid=customerid;
		this.fname=fname;
		this.lname=lname;
		this.street=street;
		this.zipcode=zipcode;
		this.cellno=cellno;
		this.email=email;
		this.identityno=identityno;
		
		}
		public Customer(String fname,String lname,String street ,int zipcode ,long cellno ,String email,String identityno) {
			
			this.fname=fname;
			this.lname=lname;
			this.street=street;
			this.zipcode=zipcode;
			this.cellno=cellno;
			this.email=email;
			this.identityno=identityno;
			
			}
		
		
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int getCustomerId() {
			// TODO Auto-generated method stub	
			return this.customerid;
		}

		@Override
		public void setCustomerId(int customerid) {
			// TODO Auto-generated method stub
			this.customerid = customerid;
		}
		
		@Override
		public String getFname() {
			// TODO Auto-generated method stub
			return this.fname;
		}

		@Override
		public void setFname(String fname) {
			// TODO Auto-generated method stub
			this.fname = fname;
		}

		@Override
		public String getLname() {
			// TODO Auto-generated method stub
			return this.lname;
		}

		@Override
		public void setLname(String lname) {
			// TODO Auto-generated method stub
			this.lname = lname;
		}

		@Override
		public String getStreet() {
			// TODO Auto-generated method stub
			return this.street;
		}

		@Override
		public void setStreet(String street) {
			// TODO Auto-generated method stub
			this.street = street;
		}

		@Override
		public int getZipCode() {
			// TODO Auto-generated method stub
			return this.zipcode;
		}

		@Override
		public void setZipcode(int zipcode) {
			// TODO Auto-generated method stub
			this.zipcode =zipcode;
		}

		
		public long getCellNo() {
			// TODO Auto-generated method stub
			return this.cellno;
		}

		@Override
		public void setCellNo(long cellno) {
			// TODO Auto-generated method stub
			this.cellno =cellno;
		}
		
		
		
		
		@Override
		public String getEmail() {
			// TODO Auto-generated method stub
			return this.email;
		}

		@Override
		public void setEmail(String email) {
			// TODO Auto-generated method stub
			this.email = email;
		}
		
		@Override
		public String getIdentityNo() {
			// TODO Auto-generated method stub
			return this.identityno;
		}
		
		

		@Override
		public void setIdentityNo(String identityno) {
			// TODO Auto-generated method stub
			this.identityno = identityno;
		}
		
			
		}


