package execute_method;
import java.util.*;
import java.sql.*;

public class code_1 {
	public static void main(String[] args) {
		
		Connection c = null;
		
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish connection
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			// statement
			Statement s = c.createStatement();
			
			boolean b = s.execute("select * from section_a");
			
			if(b) {
				ResultSet rs = s.getResultSet();
				
				while(rs.next()) {
					System.out.println("class number: " + rs.getInt(1));
					System.out.println("Name: " + rs.getString(2));
					System.out.println("Email: " + rs.getString(3));
					System.out.println("Phone number: " + rs.getLong(4));
					System.out.println("Roll number: " + rs.getLong(5));
				}
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(c!=null) {
				try {
					c.close();
				}
				catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
	}
}