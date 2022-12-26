package backend;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.*;

public class DataBase {
	
	static Connection conLogin;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conLogin= DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","1234" );
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void insertRecord(String name,String email,String mobile,String password) {
		try {
		Statement stmt= conLogin.createStatement();
		System.out.println("registering in DB");
		String sql = "insert into users values('"+name+"','"+email+"','"+mobile+"','"+password+"')";
		System.out.println(sql);
		
		stmt.execute(sql);
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	public static boolean checkLogin(String mobile,String password) {
		
		try {
		
			Statement stmt= conLogin.createStatement();
			System.out.println("registering in DB");
			String sql = "select * from users";
			System.out.println(sql);
			
			ResultSet result= stmt.executeQuery(sql);
			 
			while(result.next()) {
				String mobileDB= result.getString("mobile");
				String passwordDB = result.getString("password");
				System.out.println(mobileDB+" "+passwordDB);
				
				if(mobileDB.equals(mobile ) && passwordDB.equals(password))
					return true;
				
			}
			
			return false;
			
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		
		
	}
	
public static String getName(String mobile,String password) {
		
		try {
		
			Statement stmt= conLogin.createStatement();
			System.out.println("registering in DB");
			String sql = "select * from users";
			System.out.println(sql);
			
			ResultSet result= stmt.executeQuery(sql);
			 
			while(result.next()) {
				String mobileDB= result.getString("mobile");
				String passwordDB = result.getString("password");
				String name = result.getString("name");
				System.out.println(mobileDB+" "+passwordDB);
				
				if(mobileDB.equals(mobile ) && passwordDB.equals(password))
					return name;
				
			}
			
			return null;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		
	}

	
	
	
	

}
