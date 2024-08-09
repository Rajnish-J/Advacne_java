package CRUD_opt_object;
import java.util.*;

public class MainClass {
	
	//Scanner class object
	static Scanner sc = new Scanner(System.in);
	
	// Main method
	public static void main(String[] args) throws Exception{
		
		// option showing
		System.out.println("1. SignUp \2. Signin \3. Logout");
		
		// collection choice from user
		System.out.print("Enter the choice: ");
		int choice = sc.nextInt();
		
		DB_Methods db = new DB_Methods();
		
		// switch statement
		switch(choice) {
		
			// Signin case
			case 1 : {
				
				System.out.println("Welocme to the signin Page....");
				System.out.print("Enter Id: ");
				int id = sc.nextInt();
				
				System.out.print("Enter First Name: ");
				String fname = sc.next();
				
				System.out.print("Enter Last Name: ");
				String lname = sc.next();
				
				System.out.print("Enter mail ID: ");
				String mail = sc.next();
				
				System.out.print("Enter password: ");
				String pass = sc.next();
				
				System.out.print("Enter dob: ");
				String dob = sc.next();
				
				System.out.print("Enter phone: ");
				long phone = sc.nextLong();
				
				User_obj u = new User_obj();
				u.setId(id);
				u.setFirst_name(fname);
				u.setLast_name(lname);
				u.setEmail(mail);
				u.setPassword(pass);
				u.setDob(dob);
				u.setPhone_no(phone);
				
				db.save(u);
				
				break;
			}
			
			// Login case
			case 2 : {
				
				// fetching email id from user to verify
				System.out.print("Enter the Email - ID: ");
				String email = sc.next();
				
				User_obj u = db.findbyemail(email);
				
				// if condition for checking the email Id is present in the database or not
				if(u != null) {
					
					// fetching Password to verify
					System.out.print("Enter the Password: ");
					String pass = sc.next();
					
					// if condition for verifying password
					if(pass.equals(u.getPassword())) {
						System.out.print("1. Fetch all the data\n2. update the data\n3. find by ID\n4. delete by ID");
						int choice_1 = sc.nextInt();
						
						switch(choice_1) {
							case 1 : {
								ArrayList<<User_obj> al = db.fetchAll();
								
								for(User_obj u1 : al) {
									System.out.println(u1);
								}
								break;
							}
							case 2 : {
								System.out.print("Enter the ID: ");
								int id = sc.nextInt();
								User_obj u2 = db.findbyId(id);
								
								if(u2 != null) {
									System.out.println("1. Update First name\n2. Update Second name\n3. Update email/n4. Update password/n5. update dob/n6. Update Phone number");
									System.out.print("Enter the choice: ");
									int choice_2 = sc.nextInt();
									
									switch(choice_2) {
										case 1:{
											System.out.println("Enter the First name: ");
											String fname = sc.next();
										}
										case 2:{
											System.out.println("Enter the Last name: ");
											String lname = sc.next();
										}
										case 3:{
											System.out.println("Enter the email: ");
											String mail = sc.next();
										}
										case 4:{
											System.out.println("Enter the password: ");
											String password = sc.next();
										}
										case 5:{
											System.out.println("Enter the DOB: ");
											String dob = sc.next();
										}
										case 6:{
											System.out.println("Enter the Phone number: ");
											long phone = sc.nextLong();
										}
									}
								}
							}
						}
					}
				}
				
				break;
			}
			
			// LogOut - case
			case 3 : {
				break;
			}
		}
	}
}
