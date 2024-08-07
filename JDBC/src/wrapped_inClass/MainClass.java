package wrapped_inClass;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ID: ");
		int id = sc.nextInt();
		
//		System.out.print("Enter the first name: ");
//		String fname = sc.next();
//		
//		System.out.print("Enter the last name: ");
//		String lname = sc.next();
//		
//		System.out.print("Enter the Email ID: ");
//		String mail = sc.next();
//		
//		System.out.print("Enter the password: ");
//		String password = sc.next();
//		
//		System.out.print("Enter the Date of Birth: ");
//		String dob = sc.next();
//		
//		System.out.print("Enter the phone number: ");
//		double number = sc.nextDouble();
		
		DB_methods db = new DB_methods();
		
//		for fetch all method:
//		try {
//			ArrayList<User> user_al = db.fetchAll();
//			for(User u : user_al) {
//				System.out.println(u);
//			}
//			db.delete(1);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		for update method:
		try {
			User u = db.findByID(1);
			if(u != null) {
				// here call the setter methods to update the values
				// for example, I taken phone number
				
				u.setPhone_no(917113);
				db.update(u);
			}
			else {
				System.out.println("data is not present");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}