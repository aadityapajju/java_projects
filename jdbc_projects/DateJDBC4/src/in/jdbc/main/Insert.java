package in.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import in.jdbc.util.JdbcUtil;

public class Insert {

	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
		
		//Resources used
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Scanner sc = null;
		
		try {
			//taking use of util code used in JdbcUtil class
			String insertQuery="insert into empInfo(lastName, dob) values (?, ?)";
			connection = JdbcUtil.DbConnection();
			if(connection != null) {				
				statement = connection.prepareStatement(insertQuery);
			}
			if(statement != null) {
				 sc = new Scanner(System.in);
				 System.out.println("Enter lastname: ");
				 String lastName  = sc.next();
				 System.out.println("Enter dob(dd-mm-yyyy): ");
				 String dob  = sc.next();
				 
				 SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				 Date utilDate = sdf.parse(dob);
				 
				  java.sql.Date sqlDate= new java.sql.Date(utilDate.getTime());
				  
				  
				 //setting the value for prepared statement				 
				    statement.setString(1, lastName);
				    statement.setDate(2, sqlDate);
				 
				    //processing
				 int rowAffected = statement.executeUpdate();
				 if(rowAffected == 1) {
					 System.out.println("Insertion Success");
				 }else {
					 System.out.println("Insertion failed");
				 }
				 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//Closing resource
		finally{
			try {
				JdbcUtil.closeResources(resultset, statement, connection);
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

	}

	private static SimpleDateFormat SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
