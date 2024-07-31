package dynamic_input;

import java.sql.*;
import java.util.*;

public class code_2 {

	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter the class number: ");
			int c_no = sc.nextInt();
			
			System.out.print("Enter the student name: ");
			String s_name = sc.next();
			
//			System.out.print("Enter the student email-Id: ");
//			String mail = sc.next();
//			
//			System.out.print("Enter the student phone_no: ");
//			double p_no = sc.nextDouble();
			
			System.out.print("Enter the student roll_no: ");
			double roll_no = sc.nextDouble();
			
			
			try {
				// step 1
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// step 2
				String link = "jdbc:mysql://localhost:3306/student_db";
				String username = "root";
				String password = "root";
				Connection c = DriverManager.getConnection(link, username, password);
				
				// step 3
				PreparedStatement ps = c.prepareStatement("insert into section_a values(?,?,?)");
				
				ps.setInt(1, c_no);
				ps.setString(2, s_name);
//				ps.setString(3, mail);
//				ps.setDouble(4, p_no);
				ps.setDouble(3, roll_no);
				
				// step 4
				ps.executeUpdate();
				
				// step 5
				c.close();
				
				System.out.println("Inserted");
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
}

