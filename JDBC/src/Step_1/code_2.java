package Step_1;
import java.sql.*;

public class code_2 {
	public static void main(String[] args) {
		try {
			//second way to load the driver or reigister the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Done");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}