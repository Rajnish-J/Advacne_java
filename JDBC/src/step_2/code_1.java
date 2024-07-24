package step_2;
import java.sql.*;

public class code_1 {
	public static void main(String[] args) {
		try {
			
			// 1st step: load the driver or register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2nd step: establish connection
			Connection c = DriverManager.getConnection("");
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
}
