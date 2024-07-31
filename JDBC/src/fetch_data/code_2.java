// dynamic way fetch by Id

package fetch_data;
import java.sql.*;
import java.util.*;

public class code_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String name = sc.next();
		
		try {
			// step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2
			String link = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "root";
			Connection c = DriverManager.getConnection(link, username, password);
			
			// step 3
			PreparedStatement ps = c.prepareStatement("select name, phone_no from section_a where name = ?");
			ps.setString(1,name);
			
			// step 4
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("name: " + rs.getString("name"));
				System.out.println("phone number: " + rs.getLong("phone_no"));
			}
			else {
				System.out.println("Movie not found");
			}
			
			
			// fetching the data:
			while(rs.next()) {
				// using column index to fetch
				System.out.println("name: " + rs.getString(2));
				System.out.println("phone number: " + rs.getLong(4));
				
				// using column name to fetch
				System.out.println("mail: " + rs.getString("email_id"));
				System.out.println();
			}
			
			//step 5
			c.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
