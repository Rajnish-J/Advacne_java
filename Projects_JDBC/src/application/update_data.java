//UPDATE
package application;
import java.util.*;
import java.sql.*;

public class update_data {
	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	public static void update() {
		try {
			
			//1.LOAD THE DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. ESTABLISH CONNECTION
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_clone", "root", "root");
			
			//3.CREATE STATEMENT
			
			System.out.println("1. productName\n2. productPrice\n3. productBrand");
			System.out.print("Enter the option: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				System.out.println("Enter pid :");
				int id=sc.nextInt();
				System.out.println("Enter the Product Name :");
				String name=sc.next();
				PreparedStatement ps=con.prepareStatement("UPDATE mobiles SET p_name=? WHERE idProducts=?");
				ps.setString(1,name);
				ps.setInt(2,id);
				ps.executeUpdate();
				break;
			}
			case 2: {
				System.out.println("Enter pid :");
				int id=sc.nextInt();
				System.out.println("Enter the Product Price :");
				double price = sc.nextDouble();
				PreparedStatement ps=con.prepareStatement("UPDATE mobiles SET p_price=? WHERE idProducts=?");
				ps.setDouble(1,price);
				ps.setInt(2,id);
				ps.executeUpdate();
				break;
			}
			case 3: {
				System.out.println("Enter pid :");
				int id=sc.nextInt();
				System.out.println("Enter the Product Brand :");
				String name=sc.next();
				PreparedStatement ps=con.prepareStatement("UPDATE mobiles SET p_brand=? WHERE idProducts=?");
				ps.setString(1,name);
				ps.setInt(2,id);
				ps.executeUpdate();
				break;
			}
			default:
				System.out.println("Enter the valid option");
			}
			System.out.println("Execution Sucessfully");
		} 
		catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//5.CLOSE THE CONNECTION
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}