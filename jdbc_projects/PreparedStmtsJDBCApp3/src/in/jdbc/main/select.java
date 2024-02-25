package in.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.jdbc.util.JdbcUtil;

public class select {

	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
		
		//Resources used
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Scanner sc = null;
		
		try {
			//taking use of util code used in JdbcUtil class
			String SelectQuery="select * from employee where empId=?";
			connection = JdbcUtil.DbConnection();
			if(connection != null) {				
				statement = connection.prepareStatement(SelectQuery);
			}
			if(statement != null) {
				 sc = new Scanner(System.in);
				 System.out.println("Enter empId: ");
				 Integer empId  = sc.nextInt();
				 
				 //setting the value for prepared statement
				 statement.setInt(1, empId);
				 
				 resultset = statement.executeQuery(); 				 			 
			}
			if(resultset != null) {
				if(resultset.next()) {
					System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
				}
				else {
					System.out.println("ID not found");
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
