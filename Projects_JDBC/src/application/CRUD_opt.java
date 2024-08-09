package application;
import java.util.*;
import java.sql.*;

public class CRUD_opt {
	
	public static void main(String[] args) {
		// Scanner object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Insert\n2.Update\n3.Delete\n4.Select\n5.Search By Brand\n6.Search Within Price\n7.Sort Price");
		System.out.print("Enter your option :");
		int choice=sc.nextInt();
				
		switch(choice) {
			case 1:{
				insert_data.insert();
				break;
			}
			case 2:{
				update_data.update();
				break;
			}
			case 3:{
				delete_data.delete();
				break;
			}
			case 4:{
				select_table.select();
				break;
			}
			case 5:{
				filter_by_brand.brand();	
				break;
			}
			case 6:{
				sort_price.Price();
				break;
			}
			case 7:{
				sort.sortPrice();
				break;
			}
			default:{
				System.out.println("Enter Valid Option");
			}
		}
	}
}