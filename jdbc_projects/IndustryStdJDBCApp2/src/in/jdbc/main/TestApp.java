package in.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.jdbc.util.JdbcUtil;

public class TestApp {

	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
		
		//Resources used
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			//taking use of util code used in JdbcUtil class
			connection = JdbcUtil.DbConnection();
			if(connection != null) {
				statement = connection.createStatement();
			}
			if(statement != null) {
				 resultset = statement.executeQuery("select * from employee");
			}
			if(resultset != null) {
				System.out.println("empID\tempName\tdesignation");
				while(resultset.next()) {
					System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)); //n is coloumn
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

	}

}
