package delete_query;

import java.sql.*;

public class code_1 {
	public static void main(String[] args) {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish Connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
			
			// create statement
			Statement s = c.createStatement(); // return --> new statementImpl();
			
			// execute query
			s.executeUpdate("delete from section_a where Roll_no in (330)");
			
			// close the connection
			c.close();
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}