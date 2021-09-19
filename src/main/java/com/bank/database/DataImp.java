package com.bank.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.models.Genetateid;
import com.bank.models.User;





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
			
//			for (int x=0;x<newuser.length;x++)
//				{
//				if(newuser[x] != null) {
//					System.out.println(newuser[x].getUserId());
//					System.out.println(newuser[x].getFname());
//					System.out.println(newuser[x].getLname());
//					System.out.println(newuser[x].getuserName());
//					System.out.println(newuser[x].getPassword());
//					System.out.println(newuser[x].getUserTypeID());
//					System.out.println("");
//				}
//				}
//			System.out.println("database"+ result);			
			return result;
		}
	
		
		
		public boolean registerUser(User newUser) {
			// TODO Auto-generated method stub
			//completed
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
				System.out.println(ps);
				ps.execute();
				
				success = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
				System.out.println(ps);
				ps.setInt(1, newcustomer.getCustomerId());
				ps.setString(2, newcustomer.getFname());
				ps.setString(3, newcustomer.getLname());
				ps.setString(4, newcustomer.getStreet());
				ps.setInt(5, newcustomer.getZipCode());
				ps.setLong(6, newcustomer.getCellNo());
				ps.setString(7, newcustomer.getEmail());
				ps.setString(8, newcustomer.getIdentityNo());
				
				System.out.println(ps);
				ps.execute();
				
				success = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return success;
		}
		public boolean registerAccount(Account newaccount) {
			// TODO Auto-generated method stub
			//completed
			boolean success = false;
			//1. Connect to database!
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				
				String sql = "insert into b_account (acc_id, acc_name, balance, cus_id, acc_type_id) VALUES (?,?,?,?,?)";
			
				
				PreparedStatement ps = connection.prepareStatement(sql);
				System.out.println(ps);
				
				ps.setInt(1, newaccount.getAccountid());
				ps.setString(2, newaccount.getAccountname());
				ps.setDouble(3, newaccount.getBalance());
				ps.setInt(4, newaccount.getCusid());
				ps.setInt(5, newaccount.getAcctypeid());
				
				System.out.println(ps);
				ps.execute();
				
				success = true;
				
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
				System.out.println(ps);
				
				ps.setInt(1, newaccount.getAccountid());
				ps.setString(2, newaccount.getAccountname());
				ps.setDouble(3, newaccount.getBalance());
				ps.setInt(4, newaccount.getCusid());
				ps.setInt(5, newaccount.getAcctypeid());
				ps.setInt(6, newaccount.getCusid2());
				System.out.println(ps);
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
	
	
	
			try(Connection connection = DriverManager.getConnection(url, username, password)){
		
				String sql = "SELECT cus_id, acc_id, isnew FROM b_idGenerator where isNEW = true";
		
				PreparedStatement ps = connection.prepareStatement(sql);
		
				ResultSet rs = ps.executeQuery();
		        
				while(rs.next()) {
				gid = new Genetateid(rs.getInt("cus_id"), 
							rs.getInt("acc_id"), 
							rs.getBoolean("isnew"));
				}
				
				
				int ids =gid.getCustomerid();
				System.out.println("---------------------------------"+ids);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			try(Connection connection = DriverManager.getConnection(url, username, password)){
		
					String sql = "update b_idGenerator set isNew=false where isNew=true";
						
					PreparedStatement ps = connection.prepareStatement(sql);
	
					ps.execute();
				
			} catch (SQLException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			//2. Write a SQL statement String
			
			String sql = "insert into b_idGenerator (cus_id, acc_id, isnew) values(?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, gid.getCustomerid()+1);
			ps.setInt(2, gid.getAccountid()+1);
			ps.setBoolean(3, true);
			System.out.println(ps);
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
			return gid;
		}

}


































