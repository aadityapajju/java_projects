package in.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Date;
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
			String SelectQuery="select * from empInfo where lastName=?";
			connection = JdbcUtil.DbConnection();
			if(connection != null) {				
				statement = connection.prepareStatement(SelectQuery);
			}
			if(statement != null) {
				 sc = new Scanner(System.in);
				 System.out.println("Enter lastName: ");
				 String lastName  = sc.next();
				 
				 //setting the value for prepared statement
				 statement.setString(1, lastName);
				 
				 resultset = statement.executeQuery(); 				 			 
			}
			if(resultset != null) {
				if(resultset.next()) {
					Date sqlDate = resultset.getDate(2);
					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					String stringDate = sdf.format(sqlDate);
					System.out.println(resultset.getString(1)+" "+stringDate);
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
