package dbconnection;

import java.sql.*;

public class DbConnection {

	private DbConnection() {
    }
    
    private static Connection connection = null;
    
	public static Connection getConnection() throws SQLException {
		
		
		try {
			if(connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =  DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student_management_system", "root", "root");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
	
	}
	
	

}
