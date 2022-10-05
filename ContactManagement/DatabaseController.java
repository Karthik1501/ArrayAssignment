package contactmanagement;

import java.sql.*;

public class DatabaseController {

	private Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "user1",
			"8621");
	DatabaseController()throws SQLException{
		
	}
	
	public void addContact(String name, String phone, String lable, String email) {
		try {
			PreparedStatement addContact = connection.prepareStatement(String.format("INSERT INTO Contact VALUES('%s','%s','%s','%s')",name,phone,lable,email));
			int result = addContact.executeUpdate();
			if(result==1)
				System.out.println("\n****** Contact Added ******\n");
			else
				System.out.println("\n****** Contact Alresy exist ******\n");
		} catch (SQLException e) {
			System.err.println("Contact alresy exist ");
		}
	}
	
	public void viewAllContact() {
		System.out.println("          View All Contact              ");
		try {
			PreparedStatement viewAll = connection.prepareStatement(String.format("SELECT * FROM Contact"));
			ResultSet res = viewAll.executeQuery();
			System.out.print  ("----------+-------------+-----------+----------------------+\n");
			System.out.println("   Name   |    Phone    |   Lable   |      Email           |");
			System.out.print  ("----------+-------------+-----------+----------------------+");
			while(res.next()) {
				System.out.printf("\n %-10s%-17s%-12s%-9s",res.getString(1),res.getString(2),res.getString(3),res.getString(4));
			}
			System.out.println("\n----------+-------------+-----------+----------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchOne(String type,String search){
	try {
		PreparedStatement searchOne = connection.prepareStatement(String.format("SELECT * FROM Contact where %s='%s'",type,search));
		ResultSet res = searchOne.executeQuery();
		System.out.print  ("----------+-------------+-----------+----------------------+\n");
		System.out.println("   Name   |    Phone    |   Lable   |         Email        |");
		System.out.print  ("----------+-------------+-----------+----------------------+");
		if(res.next()) {
			System.out.printf("\n %-10s%-17s%-12s%-9s",res.getString(1),res.getString(2),res.getString(3),res.getString(4));
		}
		
		System.out.println("\n----------+-------------+-----------+----------------------+");
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
	}
	
	
	
	public void updateOne(String setType, String setVal, String type,String search) {
		
		try {
			PreparedStatement searchOne = connection.prepareStatement(String.format("UPDATE Contact set %s='%s'  where %s='%s'",setType,setVal,type,search));
			int res = searchOne.executeUpdate();
			if(res==1) {
				System.out.println("\n****** Contact updated &s show it******\n");
				
				searchOne(setType,setVal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteContact(String phone) {
		try {
			PreparedStatement deleteOne = connection.prepareStatement("DELETE FROM Contact where Phone="+phone+"");
			deleteOne.executeUpdate();			
		} catch (SQLException e) {
			System.err.println("Invalid number !!!");
		}
		
	}
}
