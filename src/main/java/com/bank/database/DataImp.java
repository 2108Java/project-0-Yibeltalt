package com.bank.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.models.Genetateid;
import com.bank.models.Transaction;
import com.bank.models.User;
import java.sql.Date;




public class DataImp {


	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "Passw0rd$";
	private String url = "jdbc:postgresql://" + dbLocation + "/Bank";

		
	public int userAutenticate(String username1, String password1) {
			
			int result = 0;
			User  newuser = new User();
			try(Connection connection = DriverManager.getConnection(url, username, password)){
			
				
				String sql = "SELECT * FROM b_user where username = ? and password = ?";
					
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, username1);
				ps.setString(2, password1);	
//				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				int i =0;
				while(rs.next()) {
					
							newuser = new User(rs.getInt("user_id"),								
									rs.getString("f_name"),
									rs.getString("l_name"),
									rs.getString("username"),
									rs.getString("password"),
									rs.getInt("user_type_id"));
							i++;
				
							}
		
		result = (int)newuser.getUserTypeID();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return result;
		}
	
		
		
	public boolean registerUser(User newUser) {
			
			
			boolean success = false;
			//1. Connect to database!
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				
				String sql = "INSERT INTO b_user (f_name,l_name,username,password,user_type_id) VALUES (?,?,?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				
				
				ps.setString(1, newUser.getFname());
				ps.setString(2, newUser.getLname());
				ps.setString(3, newUser.getuserName());
				ps.setString(4, newUser.getPassword());
				ps.setInt(5, newUser.getUserTypeID());
			
				ps.execute();
				
				success = true;
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}

			
			return success;
		}
				
	public boolean registercustomer(Customer newcustomer) {
			// TODO Auto-generated method stub
			//completed
			boolean success = false;
			//1. Connect to database!
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				
				String sql = "insert into b_customer (cus_id,f_name,l_name,Street,zipcode,cellno,email,identityno) VALUES (?,?,?,?,?,?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				//System.out.println(ps);
				ps.setInt(1, newcustomer.getCustomerId());
				ps.setString(2, newcustomer.getFname());
				ps.setString(3, newcustomer.getLname());
				ps.setString(4, newcustomer.getStreet());
				ps.setInt(5, newcustomer.getZipCode());
				ps.setLong(6, newcustomer.getCellNo());
				ps.setString(7, newcustomer.getEmail());
				ps.setString(8, newcustomer.getIdentityNo());
				
				//System.out.println(ps);
				ps.execute();
				
				success = true;
				 
							 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return success;
		}
	public boolean registerAccount(Account newaccount,int usertype) {
			// TODO Auto-generated method stub
			//completed
			boolean success = false;
			//1. Connect to database!
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				if (usertype ==103)
					{
				String sql = "insert into b_account (acc_id, acc_name, balance, cus_id, acc_type_id) VALUES (?,?,?,?,?)";
			
				
				PreparedStatement ps = connection.prepareStatement(sql);
		//		System.out.println(ps);
				
				ps.setInt(1, newaccount.getAccountid());
				ps.setString(2, newaccount.getAccountname());
				ps.setDouble(3, newaccount.getBalance());
				ps.setInt(4, newaccount.getCusid());
				ps.setInt(5, newaccount.getAcctypeid());
				
		//		System.out.println(ps);
				ps.execute();
				
				success = true;
				}
				else if (usertype ==102)
				{
				String sql = "insert into b_account (acc_id, acc_name, balance, cus_id, acc_type_id,authorized) VALUES (?,?,?,?,?,?)";
			
				
				PreparedStatement ps = connection.prepareStatement(sql);
		//		System.out.println(ps);
				
				ps.setInt(1, newaccount.getAccountid());
				ps.setString(2, newaccount.getAccountname());
				ps.setDouble(3, newaccount.getBalance());
				ps.setInt(4, newaccount.getCusid());
				ps.setInt(5, newaccount.getAcctypeid());
				ps.setBoolean(6, true);
				
				
		//		System.out.println(ps);
				ps.execute();
				
				success = true;
				}	
					
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return success;
		}
	public boolean registerAccount2(Account newaccount) {
			// TODO Auto-generated method stub
			//completed
			boolean success = false;
			//1. Connect to database!
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				
				String sql = "insert into b_account (acc_id, acc_name, balance, cus_id, acc_type_id,cust_id2) VALUES (?,?,?,?,?,?)";
			
				
				PreparedStatement ps = connection.prepareStatement(sql);
				//System.out.println(ps);
				
				ps.setInt(1, newaccount.getAccountid());
				ps.setString(2, newaccount.getAccountname());
				ps.setDouble(3, newaccount.getBalance());
				ps.setInt(4, newaccount.getCusid());
				ps.setInt(5, newaccount.getAcctypeid());
				ps.setInt(6, newaccount.getCusid2());
				//System.out.println(ps);
				ps.execute();
				
				success = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return success;
		}
		


	public Genetateid getnewid() {
	
	
			Genetateid gid =new Genetateid();
	
	
	//selecting the next available ID
			try(Connection connection = DriverManager.getConnection(url, username, password)){
		
				String sql = "SELECT cus_id, acc_id, isnew FROM b_idGenerator where isNEW = true";
		
				PreparedStatement ps = connection.prepareStatement(sql);
		
				ResultSet rs = ps.executeQuery();
		        
				while(rs.next()) {
				gid = new Genetateid(rs.getInt("cus_id"), 
							rs.getInt("acc_id"), 
							rs.getBoolean("isnew"));
				}
				
				
				//int ids =gid.getCustomerid();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//updating ID's to false in the table
	
			try(Connection connection = DriverManager.getConnection(url, username, password)){
		
					String sql = "update b_idGenerator set isNew=false where isNew=true";
						
					PreparedStatement ps = connection.prepareStatement(sql);
	
					ps.execute();
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
	//generating new ID for Next time use
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			//2. Write a SQL statement String
			
			String sql = "insert into b_idGenerator (cus_id, acc_id, isnew) values(?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, gid.getCustomerid()+1);
			ps.setInt(2, gid.getAccountid()+1);
			ps.setBoolean(3, true);
			//System.out.println(ps);
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
			return gid;
		}

	
	public boolean Authauthorizeaccount(int accountid) {
				// TODO Auto-generated method stub
				boolean success = false;
				try(Connection connection = DriverManager.getConnection(url, username, password)){
					
					String sql = "UPDATE b_user set authorized = 'true' where id = ?";
					
					PreparedStatement ps = connection.prepareStatement(sql);
					
					ps.setInt(1, accountid);
					
				    ps.execute();
					success = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				
			      }
				//System.out.print(success+"on database");
				
				return success;
				}
		
		
	public double balanceofmyaccount(int cusid,String idenum) {
			double result = 0;
				try(Connection connection = DriverManager.getConnection(url, username, password)){
					
					
					String sql = "select balance from b_account where cus_id = (select cus_id from b_customer where cus_id = ? and identityno = ?)";
						
					PreparedStatement ps = connection.prepareStatement(sql);
					
					ps.setInt(1, cusid);
					ps.setString(2, idenum);	

					ResultSet rs = ps.executeQuery();
					

					while(rs.next()) {
						result = rs.getDouble("balance");
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			
			return result;
		}
		
		
	public boolean withdrawal(Transaction trs,double balance) {
			boolean success1=false,success2=false,success3=false;
			double bankbal = 0.0;
					//inserting transaction table
			try(Connection connection = DriverManager.getConnection(url, username, password)){
			
					
				String sql = "insert into b_transaction (db_account,cr_account,amount,reference,transaction_type_id) VALUES (?,?,?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				//System.out.println(ps);
				ps.setInt(1, trs.getDb_account());
				ps.setInt(2, trs. getCr_account());
				ps.setDouble(3, trs.getAmount());
				ps.setString(4, trs.getReference());
				ps.setInt(5, trs.getTranstypeid());
				
				ps.execute();
				
				success1 = true;
				 	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// updating customer balance
			try(Connection connection = DriverManager.getConnection(url, username, password)){
							
					
				double newbalance = balance-trs.getAmount();
					
				String sql = "update b_account set balance=? where acc_id= ?";
					
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setDouble(1, newbalance);
				ps.setInt(2, trs.getDb_account());

				ps.execute();
				success2= true;
			
				} catch (SQLException e) {

						e.printStackTrace();
				}
			
		//getting balance 
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			
			String sql = "SELECT balance  FROM b_account where acc_id = 9999999";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			

			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				     bankbal = rs.getDouble("balance");
						}
			} catch (SQLException e) {

					e.printStackTrace();
		}
			
		double banknewbal = bankbal + trs.getAmount();
	
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
				
			String sql = "update b_account set balance= ? where acc_id= 9999999";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, banknewbal);
			ps.execute();
			success3= true;
		
			} catch (SQLException e) {

					e.printStackTrace();
			}
		
		
		if(success1&&success2&&success3)
			return true;
		
		
		else 
			return false;
			
		
	
		
		}
		
	public boolean deposit(Transaction trs,double balance) {
		boolean success1=false,success2=false,success3=false;
		double bankbal = 0.0;
				//inserting transaction table
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
				
			String sql = "insert into b_transaction (db_account,cr_account,amount,reference,transaction_type_id) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			//System.out.println(ps);
			ps.setInt(1, trs.getDb_account());
			ps.setInt(2, trs. getCr_account());
			ps.setDouble(3, trs.getAmount());
			ps.setString(4, trs.getReference());
			ps.setInt(5, trs.getTranstypeid());
			
			ps.execute();
			
			success1 = true;
			 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// updating customer account  balance
		try(Connection connection = DriverManager.getConnection(url, username, password)){
						
				
			double newbalance = balance+trs.getAmount();
				
			String sql = "update b_account set balance=? where acc_id= ?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, newbalance);
			ps.setInt(2, trs.getCr_account());

			ps.execute();
			success2= true;
		
			} catch (SQLException e) {

					e.printStackTrace();
			}
		
	//getting balance 
	
	try(Connection connection = DriverManager.getConnection(url, username, password)){
		
		
		String sql = "SELECT balance  FROM b_account where acc_id = 9999999";
			
		PreparedStatement ps = connection.prepareStatement(sql);
		

		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			     bankbal = rs.getDouble("balance");
					}
		} catch (SQLException e) {

				e.printStackTrace();
	}
		
	double banknewbal = bankbal - trs.getAmount();

	try(Connection connection = DriverManager.getConnection(url, username, password)){
		
			
		String sql = "update b_account set balance= ? where acc_id= 9999999";
			
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setDouble(1, banknewbal);
		ps.execute();
		success3= true;
	
		} catch (SQLException e) {

				e.printStackTrace();
		}
	
	
	if(success1&&success2&&success3)
		return true;
	
	
	else 
		return false;
		
	
	
	}
	
					
				
	public int Transactioncheck(int cusid, String identno,double amount) {
		
		double balance1 = 0;
		int accid = 0;
		int result =0;
		
			try(Connection connection = DriverManager.getConnection(url, username, password)){
			String sql = "select balance ,acc_id from b_account where cus_id = (select cus_id from b_customer where cus_id = ? and identityno = ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
				
			ps.setInt(1, cusid);
			ps.setString(2,identno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				balance1 = rs.getDouble("balance");
				accid = rs.getInt("acc_id");			
			}
			//System.out.println(balance1);
			//System.out.println(accid);
			if 	(amount > balance1) {
				result = 1;
			
					}
			else if (amount< 0)
				{
				result = 2;
						}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!(result ==2 ||result==1))
			       result = accid;
				
				System.out.println(result);
			return result;
					
			
		}
		

	public boolean transferotherAccount(Transaction trs, double balance1,double balance2) {
		
		boolean success1=false,success2=false,success3=false;
		double othercust = 0.0;
				//inserting transaction table
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
				
			String sql = "insert into b_transaction (db_account,cr_account,amount,reference,transaction_type_id) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			//System.out.println(ps);
			ps.setInt(1, trs.getDb_account());
			ps.setInt(2, trs. getCr_account());
			ps.setDouble(3, trs.getAmount());
			ps.setString(4, trs.getReference());
			ps.setInt(5, trs.getTranstypeid());
			
			ps.execute();
			
			success1 = true;
			 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// updating first customer balance
		try(Connection connection = DriverManager.getConnection(url, username, password)){
						
			
			double newbalance = balance1-trs.getAmount();
				
			String sql = "update b_account set balance=? where acc_id= ?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, newbalance);
			ps.setInt(2, trs.getDb_account());

			ps.execute();
			success2= true;
		
			} catch (SQLException e) {

					e.printStackTrace();
			}
		// updating secound customer balance
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			
			double secbalance = balance2+trs.getAmount();
				
			String sql = "update b_account set balance=? where acc_id= ?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, secbalance);
			ps.setInt(2, trs.getCr_account());

			ps.execute();
			success3= true;
		
			} catch (SQLException e) {

					e.printStackTrace();
			}
		
	
	
			if(success1&&success2&&success3)
					return true;
	
	
			else 
				return false;
		
		
	}
		
	public Account  viewaccount (int cusid) {
		
		Account acc =new Account();
		
		
		//selecting the next available ID
				try(Connection connection = DriverManager.getConnection(url, username, password)){
			
					String sql = "select acc_id,acc_name,balance,cus_id,acc_type_id,date_created,authorized ,cust_id2 from b_account where cus_id = ?";
			
					PreparedStatement ps = connection.prepareStatement(sql);
					
					ps.setInt(1, cusid);
					
					ResultSet rs = ps.executeQuery();
			        
					while(rs.next()) {
					acc = new Account(rs.getInt("acc_id"), 
								rs.getString("acc_name"), 
								rs.getDouble("balance"),
								rs.getInt("cus_id"), 
								rs.getInt("acc_type_id"), 
								rs.getDate("date_created"),
								rs.getBoolean("authorized"), 
								rs.getInt("cust_id2")
							);
					}
					
					
					//int ids =gid.getCustomerid();
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		return acc;
	}
	public int Transactioncheck2(int cusid, double amount) {
	
	double balance1 = 0;
	int accid = 0;
	int result =0;
	
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		String sql = "select balance ,acc_id from b_account where cus_id = (select cus_id from b_customer where cus_id = ? )";
		
		PreparedStatement ps = connection.prepareStatement(sql);
			
		ps.setInt(1, cusid);
	
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			balance1 = rs.getDouble("balance");
			accid = rs.getInt("acc_id");			
		}
		//System.out.println(balance1);
		//System.out.println(accid);
		
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!(result ==2 ||result==1))
		       result = accid;
			
			
		return result;
				
		
	}	
		
	public double balanceofmyaccount2(int cusid) {
		double result = 0;
			try(Connection connection = DriverManager.getConnection(url, username, password)){
				
				
				String sql = "select balance from b_account where cus_id = (select cus_id from b_customer where cus_id = ? )";
					
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setInt(1, cusid);
			

				ResultSet rs = ps.executeQuery();
				

				while(rs.next()) {
					result = rs.getDouble("balance");
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		return result;
	}

	public boolean approveAccount (int cusid) {
	
		boolean successful = false;
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String sql = "update b_account set authorized = true where cus_id = ?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, cusid);
			
			ps.execute();
		
			
			successful =true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return successful;
		
	
	}
}












