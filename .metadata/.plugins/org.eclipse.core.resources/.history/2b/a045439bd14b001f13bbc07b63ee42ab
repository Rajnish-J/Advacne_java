package dynamic_input;
import java.sql.*;
import java.util.*;

public class code_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the class number: ");
		int c_no = sc.nextInt();
		
		System.out.print("Enter the student name: ");
		String s_name = sc.next();
		
		System.out.print("Enter the student email-Id: ");
		String mail = sc.next();
		
		System.out.print("Enter the student phone_no: ");
		double p_no = sc.nextLong();
		
		System.out.print("Enter the student roll_no: ");
		double roll_no = sc.nextInt();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String link = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "root";
			Connection c = DriverManager.getConnection(link, username, password);
			
			PreparedStatement ps = c.prepareStatement("insert into section_a values (?,?,?,?,?)");
			ps.setInt(1, c_no);
			ps.setString(2, s_name);
			ps.setString(3, mail);
			ps.setDouble(4, p_no);
			ps.setDouble(5, roll_no);
			
			System.out.println("Inserted");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
