package batch;
import java.util.*;
import java.sql.*;

public class code_1 {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the count: ");
		int count = sc.nextInt();
		
		Connection c = null;
		
		try {
			
			// step 1 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2 create 
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_clone","root","root");
			
			// step 3 create statement
			PreparedStatement ps = c.prepareStatement("insert into mobiles values(?,?,?,?)");
			
			for(int i = 0; i<count; i++) {
				
				System.out.print("Enter the product ID: ");
				int c_no = sc.nextInt();
				
				System.out.print("Enter the model name: ");
				String model = sc.next();
				
				System.out.print("Enter the prize of the mobile: ");
				double cost = sc.nextDouble();
				
				System.out.print("Enter the mobile brand: ");
				String brand = sc.next();
				
				System.out.println();
				
				ps.setInt(1, c_no);
				ps.setString(2, model);
				ps.setDouble(3, cost);
				ps.setString(4, brand);
				
				ps.addBatch();
				
			}
			
			// step 4 Execute method
			ps.executeBatch();
			System.out.println(count + " = Data inserted");
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally {
			// step 5 close connection
			try {
				if(c != null) {
					c.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}