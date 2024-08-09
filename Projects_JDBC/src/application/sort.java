// sort
package application;
import java.util.*;
import java.sql.*;

public class sort {
	public static void sortPrice() {
		try {  
			//1.Load Register
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2.Establish Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_clone", "root", "root");
				
			//3.Create Statement
			Statement ps=con.createStatement();
				
			//4.Execute Query
			ResultSet rs=ps.executeQuery("SELECT * FROM mobiles ORDER BY p_price");
				
			while(rs.next()) {
				System.out.println("Product ID :"+rs.getInt(1));
				System.out.println("Model Name :"+rs.getString(2));
				System.out.println("Product Price :"+rs.getDouble(3));
				System.out.println("Brand Name :"+rs.getString(4));
				System.out.println("------------------------------------------------------------------------------");
			}
				
			System.out.println("Executed");
				
			//5.Close the Connection
			con.close();
			}
			
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}