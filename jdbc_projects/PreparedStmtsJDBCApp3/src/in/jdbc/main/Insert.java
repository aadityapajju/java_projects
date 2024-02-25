package in.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String insertQuery="insert into employee(empId, empName, designation) values (?, ?, ?)";
			connection = JdbcUtil.DbConnection();
			if(connection != null) {				
				statement = connection.prepareStatement(insertQuery);
			}
			if(statement != null) {
				 sc = new Scanner(System.in);
				 System.out.println("Enter empName: ");
				 String empName  = sc.nextLine();
				 System.out.println("Enter designation: ");
				 String designation  = sc.nextLine();
				 System.out.println("Enter empId: ");
				 Integer empId  = sc.nextInt();
				 
				 //setting the value for prepared statement
				 statement.setInt(1, empId);
				 statement.setString(3, designation);
				 statement.setString(2, empName);
				 
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

}
