package fetch_data;
import java.util.*;
import java.sql.*;

public class fetch_data {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the student name: ");
		String name = sc.next();
		
		try {
			// step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2
			String link = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "root";
			Connection c = DriverManager.getConnection(link,username,password);
			
			// step 3
			PreparedStatement ps = c.prepareStatement("select * from section_a where Name = ?");
			ps.setString(1, name);
			
			// step 4
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("class number: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("Phone number: " + rs.getLong(4));
				System.out.println("Roll number: " + rs.getLong(5));
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
