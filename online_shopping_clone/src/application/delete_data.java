//DELETE
package application;
import java.util.*;
import java.sql.*;

public class delete_data {
	static Scanner sc = new Scanner(System.in);
	public static void delete() {
		try {
			
			System.out.println("Enter the Product Id :");
			int id=sc.nextInt();
				
			//1.LOAD THE DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			//2. ESTABLISH CONNECTION
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_clone", "root", "root");
				
			//3.CREATE STATEMENT
			PreparedStatement ps=con.prepareStatement("DELETE FROM Product WHERE Pro_id=?");
				
			ps.setInt(1,id);
				
			//4.EXECUTE QUERY
			ps.executeUpdate();
			
			System.out.println("Execution Sucessfully");
				
			//5.CLOSE THE CONNECTION
			con.close();
				
			} 
		catch (ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
		}
	}
}