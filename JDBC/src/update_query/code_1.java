package update_query;
import java.sql.*;

public class code_1 {
	public static void main(String[] args) {
		
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2
			String link = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "root";
			Connection c = DriverManager.getConnection(link, username, password);
			
			// step 3
			Statement s = c.createStatement();
			
			//step 4
			s.executeUpdate("update section_a set Name = 'Rajnish J' where Roll_no in (334)");
			
			// step 5
			c.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
