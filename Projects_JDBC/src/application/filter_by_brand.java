//SELECT BY Brand
package application;
import java.util.*;
import java.sql.*;

public class filter_by_brand {
	static Scanner sc = new Scanner(System.in);
	public static void brand() {
		try {
			System.out.println("Enter the Product Brand :");
			String brand=sc.next();
			 	        
			//1.Load Register
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2.Establish Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_clone", "root", "root");
			    		
			//3.Create Statement
			PreparedStatement ps=con.prepareStatement("SELECT * FROM mobiles WHERE p_brand=?");
			ps.setString(1, brand);
			    		
			//4.Execute Query
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Product ID :"+rs.getInt(1));
				System.out.println("Model Name :"+rs.getString(2));
				System.out.println("Product Price :"+rs.getDouble(3));
				System.out.println("Brand Name :"+rs.getString(4));
				System.out.println("------------------------------------------------------------------------------");
			}
			    		
			    		
			//5.Close the Connection
			con.close();
			}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}