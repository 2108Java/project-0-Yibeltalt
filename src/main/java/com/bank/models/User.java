package com.bank.models;

public class User implements DoUser{

	
	private int userid;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private int usertypeid;
	
	public User(int userid ,String fname,String lname,String username,String password,int usertypeid) {
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.username= username;
		this.password= password;
		this.usertypeid=usertypeid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getUserId() {
		// TODO Auto-generated method stub	
		return this.userid;
	}

	@Override
	public void setUserId(int userid) {
		// TODO Auto-generated method stub
		this.userid = userid;
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
	public String getuserName() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public void setUserName(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password =password;
	}

	@Override
	public int getUserTypeID() {
		// TODO Auto-generated method stub
		return this.usertypeid;
	}

	@Override
	public void setUserType(int usertypeid) {
		// TODO Auto-generated method stub
		this.usertypeid = usertypeid;
	}

	
		
	}

