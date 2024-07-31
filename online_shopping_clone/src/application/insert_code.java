package application;
import java.util.*;
import java.sql.*;

public class insert_code {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the product Id: ");
		int p_id = sc.nextInt();
		
		System.out.print("Enter the product name: ");
		String p_name = sc.next();
		
		System.out.print("Enter the product price: ");
		double p_no = sc.nextDouble();
		
		System.out.print("Enter the product brand: ");
		String p_brand = sc.next();
		
		try {
			// step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2
			String link = "jdbc:mysql://localhost:3306/amazon_clone";
			String un = "root";
			String passowrd = "root";
			Connection c = DriverManager.getConnection(link, un, passowrd);
			
			// step 3
			PreparedStatement ps = c.prepareStatement("insert into mobiles values (?,?,?,?)");
			
			ps.setInt(1, p_id);
			ps.setString(2, p_name);
			ps.setDouble(3, p_no);
			ps.setString(4, p_brand);
			
			// step 4
			ps.executeUpdate();
			
			// step 5
			c.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
