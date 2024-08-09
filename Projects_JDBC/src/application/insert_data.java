//insert
package application;
import java.util.*;
import java.sql.*;

public class insert_data {
	static Scanner sc = new Scanner(System.in);
	public static void insert() {
		try {
				
			//1.Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			//2.Establish Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_clone", "root", "root");
			System.out.print("Enter Product Id :");
			int pid=sc.nextInt();
			System.out.print("Enter the model name :");
			String p_name=sc.next();
			System.out.print("Enter the product price :");
			double p_price=sc.nextDouble();
			System.out.print("Enter Product Price :");
			String brand=sc.next();
			
			//3.Create Statement
			PreparedStatement ps=con.prepareStatement("INSERT INTO mobiles VALUES(?,?,?,?)");
			ps.setInt(1,pid);
			ps.setString(2,p_name);
			ps.setDouble(3,p_price);
			ps.setString(4, brand);
				
			//4.Execute the query
			ps.executeUpdate();
				
			//5.Close the Connection
			con.close();
				
			System.out.println("Insert Sucessfully");
				
			}
			
		catch(ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
		}	
	}
}
