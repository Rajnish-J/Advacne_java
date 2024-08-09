package CRUD_opt_object;

public class User_obj {
	
	// private => attributes
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String dob;
	private long phone_no;
	
	// ID => getter.
	public int getId() {
		return id;
	}
	
	// ID => setter 
	public void setId(int id) {
		this.id = id;
	}
	
	// First Name => getter
	public String getFirst_name() {
		return first_name;
	}
	
	// First Name => setter 
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	// Last Name => getter
	public String getLast_name() {
		return last_name;
	}
	
	// Last Name => setter
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	// email => getter
	public String getEmail() {
		return email;
	}
	
	// email => setter
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Password => getter
	public String getPassword() {
		return password;
	}
	
	// Password => setter
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Date of Birth => getter
	public String getDob() {
		return dob;
	}
	
	// Date of Birth => setter
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	// Phone number => getter
	public long getPhone_no() {
		return phone_no;
	}
	
	// Phone number => setter
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	@Override
	public String toString() {
		return "User_obj [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", phone_no=" + phone_no + "]";
	}

}
