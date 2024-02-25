package in.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	//load and register the driver
	static {		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	//Establish Connection		
	public static Connection DbConnection() throws SQLException {		
				String url = "jdbc:mysql://localhost:3306/Company"; //Company is DB Name
				String user = "root";
				String password = "Sql@2024";
				return DriverManager.getConnection(url, user, password);
	}
	
	// Close the resources
	public static void closeResources(ResultSet resultset, Statement statement, Connection connection) throws SQLException {
		if(resultset != null) {
			resultset.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}

}
