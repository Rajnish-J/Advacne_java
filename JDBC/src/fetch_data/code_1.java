// static way

package fetch_data;
import java.sql.*;

public class code_1 {
	public static void main(String[] args) {
		try {
			// step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2
			String link = "jdbc:mysql://localhost:3306/student_db";
			String username = "root";
			String password = "root";
			Connection c = DriverManager.getConnection(link, username, password);
			
			// step 3
			Statement s = c.createStatement();
			
			// step 4
			ResultSet rs = s.executeQuery("select * from section_a");
			
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


//ResultSet
//	
//	next() -> check for data is present or not

//	getInt()

//	getString()

//	getDouble()

//	getFloat()

//	getShort()

//	getLong()