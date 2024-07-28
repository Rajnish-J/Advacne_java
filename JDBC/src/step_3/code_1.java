package step_3;

import java.sql.*;

public class code_1 {
	public static void main(String[] args) {
		try {
			
			// 1st step: load the driver or register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2nd step: establish connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			// 3rd step: create statement
			
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}	
}
