package com.bank.models;
import java.sql.Date;
public class Transaction {

	private int tranid;
	private int db_account;
	private int cr_account;
	private double amount;
	private String reference;
	private Date datecreated;
	private int transtypeid;
	
	
	
	public Transaction (int db_acc,int account_id,Double amount,String mess,int transid) 
		{
		super();
		this.db_account =db_acc;
		this.cr_account =account_id;
		this.amount=amount;
		this.reference =mess;
		this.transtypeid=transid;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getTranid() {
		return tranid;
	}
	public void setTranid(int tranid) {
		this.tranid = tranid;
	}
	public int getDb_account() {
		return db_account;
	}
	public void setDb_account(int db_account) {
		this.db_account = db_account;
	}
	public int getCr_account() {
		return cr_account;
	}
	public void setCr_account(int cr_account) {
		this.cr_account = cr_account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public int getTranstypeid() {
		return transtypeid;
	}
	public void setTranstypeid(int transtypeid) {
		this.transtypeid = transtypeid;
	}
	
	
	
	
	
	
}
