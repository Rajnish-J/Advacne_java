package CRUD_opt_object;
import java.sql.*;
import java.util.*;

public class DB_Methods {

	// DB connection data
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String dburl = "jdbc:mysql://localhost:3306/user_db";
	static String username = "root";
	static String password = "root";

	// connection null - object
	static Connection c = null;
	
	// Insert method...
	public void save(User_obj u) throws Exception{
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2, u.getFirst_name());
		ps.setString(3, u.getLast_name());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPassword());
		ps.setString(6, u.getDob());
		ps.setLong(7, u.getPhone_no());
		
		ps.executeUpdate();
		System.out.println("Data Saved");
	}
	
	// findBy ID method
	public User_obj findbyId(int id) throws Exception{
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			int id1 = rs.getInt("id");
			String fname = rs.getString("First_name");
			String lname = rs.getString("Lirst_name");
			String email = rs.getString("mail");
			String password = rs.getString("password");
			String dob = rs.getString("dob");
			long phone = rs.getLong("phone_no");
			
			User_obj u = new User_obj();
			
			u.setId(id1);
			u.setFirst_name(fname);
			u.setLast_name(lname);
			u.setEmail(email);
			u.setPassword(password);
			u.setDob(dob);
			u.setPhone_no(phone);
			
			return u;
		}
		else {
			return null;
		}
	}
	
	public ArrayList<User_obj> fetchAll() throws Exception{
				
		ArrayList<User_obj> al = new ArrayList();
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from user");

		while(rs.next()) {
			
			int id1 = rs.getInt("id");
			String fname = rs.getString("First_name");
			String lname = rs.getString("Lirst_name");
			String email = rs.getString("mail");
			String password = rs.getString("password");
			String dob = rs.getString("dob");
			long phone = rs.getLong("phone_no");
			
			User_obj u = new User_obj();
			
			u.setId(id1);
			u.setFirst_name(fname);
			u.setLast_name(lname);
			u.setEmail(email);
			u.setPassword(password);
			u.setDob(dob);
			u.setPhone_no(phone);
			
			al.add(u);
		}
		return al;
	}
	
	
	public void update(User_obj u) throws Exception{
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("update user set First_name = ? Last_name = ?, mail = ?, password = ?, dob = ?, phone_no = ?" + " where id = ?");
		
		ps.setInt(1, u.getId());
		ps.setString(2, u.getFirst_name());
		ps.setString(3, u.getLast_name());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPassword());
		ps.setString(6, u.getDob());
		ps.setLong(7, u.getPhone_no());
		
		ps.executeUpdate();
		System.out.println("Data updated");
	}
	
	public void delete(int id) throws Exception{
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("delete from user where id = ?");
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		System.out.println("Data deleted");
	}
	
	public User_obj findbyemail(String Email) throws Exception{
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("select * from user where mail = ?");
		ps.setString(1, Email);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			int id1 = rs.getInt("id");
			String fname = rs.getString("First_name");
			String lname = rs.getString("Lirst_name");
			String email = rs.getString("mail");
			String password = rs.getString("password");
			String dob = rs.getString("dob");
			long phone = rs.getLong("phone_no");
			
			User_obj u = new User_obj();
			
			u.setId(id1);
			u.setFirst_name(fname);
			u.setLast_name(lname);
			u.setEmail(email);
			u.setPassword(password);
			u.setDob(dob);
			u.setPhone_no(phone);
			
			return u;
		}
		else {
			return null;
		}
	}
}