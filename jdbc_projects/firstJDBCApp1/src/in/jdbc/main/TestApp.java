package in.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish Connection
		
		String url = "jdbc:mysql://localhost:3306/Company"; //Company is DB Name
		String user = "root";
		String password = "Sql@2024";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//Create a Statement object
		Statement statement = connection.createStatement();
		
		//Execute query for selectedQuery starts
		/*String sqlSelectedQuery = "select empId, empName,designation from employee";
		ResultSet resultset =  statement.executeQuery(sqlSelectedQuery );*/
		//Execute query for selectedQuery ends
		
		//Execute query for insertQuery starts
		/*String sqlInsertQuery = "insert into employee(empId, empName , designation) values (105, 'Achut', 'STC');";
	    int rowAffected = statement.executeUpdate(sqlInsertQuery);*/
		//Execute query for insertQuery ends
	    
		
	  //Execute query for delete Query starts
	  		/*String sqlDeleteQuery = "delete from employee where empId = 105";
	  	    int rowDeleted = statement.executeUpdate(sqlDeleteQuery);*/
	  		//Execute query for delete Query ends
	  	    
	  	//Execute query for update Query starts
	  		String sqlUpdateQuery = "update employee set designation = 'TC' where empId = 101";
	  	    int rowUpdate = statement.executeUpdate(sqlUpdateQuery);
	  		//Execute query for update Query ends
	  	    
		//Process the result for selected query starts
		/*System.out.println("empID\tempName\tdesignation");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)); //n is coloumn
		}*/
		//Process the result for selected query ends
		
	  //Process the result for insert query starts
	  		/*if(rowAffected == 1) {
	  			System.out.println("Insertion success");
	  		}else {
	  			System.out.println("Insertion failed");
	  		}*/
	  		//Process the result for insert query ends
		
	  	//Process the result for delete query starts
	  		/*if(rowDeleted == 1) {
	  			System.out.println("deletion success");
	  		}else {
	  			System.out.println("deletion failed");
	  		}*/
	  		//Process the result for delete query ends
	  	    
	  	//Process the result for update query starts
	  		if(rowUpdate == 1) {
	  			System.out.println("update success");
	  		}else {
	  			System.out.println("update failed");
	  		}
	  		//Process the result for update query ends
		// Close the resources
		//resultset.close();  //its for selected query
		statement.close();
		connection.close();
		
		
		

	}

}
