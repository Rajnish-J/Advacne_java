package wrapped_inClass;
import java.sql.*;
import java.util.*;

public class DB_methods {

	static String driver = "com.mysql.cj.jdbc.Driver";
	static String dburl = "jdbc:mysql://localhost:3306/user_db";
	static String username = "root";
	static String password = "root";
	
	static Connection c = null;
	
	public void save(User u) throws Exception{
		
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
		
	}
	
	public User findByID(int id) throws Exception{
		
		User u = new User();
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		
		return u;
		
	}
	
	public ArrayList<User> fetchAll() throws Exception{
		
		ArrayList<User> al = new ArrayList();
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from user");
		
		while(rs.next()) {
			int id1 = rs.getInt("id");
			String fname = rs.getString("First_name");
			String lname = rs.getString("Last_name");
			String email = rs.getString("mail");
			String password = rs.getString("password");
			String dob = rs.getString("dob");
			long phone = rs.getLong("phone_no");
			
			User u = new User();
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
	
	
	public void delete(int id) throws Exception{
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("delete from user where id = ?");
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public void update(User u) throws Exception{
		
		Class.forName(driver);
		c = DriverManager.getConnection(dburl, username, password);
		
		PreparedStatement ps = c.prepareStatement("update user set First_name = ?, Last_name = ?, mail = ?, password = ?, dob = ?, phone_no = ? where id = ?");
		
		ps.setString(1, u.getFirst_name());
		ps.setString(2, u.getLast_name());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getPassword());
		ps.setString(5, u.getDob());
		ps.setLong(6, u.getPhone_no());
		ps.setInt(7, u.getId());
		
		ps.executeUpdate();
		System.out.println("Data updated");
	}
}