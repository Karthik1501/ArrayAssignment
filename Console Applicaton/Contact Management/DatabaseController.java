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
				System.out.println("\n********** Contact Added **********\n");
			else
				System.out.println("\n********** Contact Alresy exist **********\n");
		} catch (SQLException e) {
			System.err.println("Insert query issue ");
		}
	}
	
	public void addCallLog( String phone,String duration) {
		try {
			PreparedStatement addCall = connection.prepareStatement(String.format("INSERT INTO callhirtory(phone,duration) VALUES('%s','%s')",phone,duration));	
			int  res = addCall.executeUpdate();
			
			if(res==1) {
				System.out.println("Call Ended. Recorded stored ");
			}
		} catch (SQLException e) {
			System.err.println("Query issue ");
		}
	}
	
	
	
	public void sendSms( String phone,String sms) {
		try {
			PreparedStatement addSms = connection.prepareStatement(String.format("INSERT INTO smslog(phone,sms) VALUES('%s','%s')",phone,sms));
			int result = addSms.executeUpdate();
			if(result==1)
				System.out.println("\n********** Sms sent Successfully **********\n");
		} catch (SQLException e) {
			System.err.println("Insert query issue ");
		}
	}
	
	
	public void viewCallHistory( String phone) {
		try {
			PreparedStatement callLog;
			if(phone.length()>2)
			     callLog= connection.prepareStatement(String.format("select Contact.name,callhirtory.phone,callhirtory.duration,callhirtory.calllog from Contact right join callhirtory on Contact.phone = callhirtory.phone where callhirtory.phone='%s' order by calllog desc",phone));
			else
				 callLog= connection.prepareStatement(String.format("select Contact.name,callhirtory.phone,callhirtory.duration,callhirtory.calllog from Contact right join callhirtory on Contact.phone = callhirtory.phone order by calllog desc"));

			ResultSet viewLog = callLog.executeQuery();
			
           if(!viewLog.next()) {
				if(phone.length()>2) {
				System.out.println("You haven't sent any Messages to this "+phone);
				System.out.println("Try sending one !!!");
				}else
					System.out.println("Empty !!!!!!!!");
				return;
			}
			System.out.print  ("----------+-------------+-----------------+------------------------+\n");
			System.out.println("   Name   |    Phone    |   Duration      |        callLog         |");
			System.out.print  ("----------+-------------+-----------------+------------------------+\n");
			System.out.printf("\n%-10s|%-13s|%-11s|%-22s|",viewLog.getString(1),viewLog.getString(2),viewLog.getString(3),viewLog.getString(4));
			while(viewLog.next()) {
				System.out.printf("\n%-10s|%-13s|%-11s|%-22s|",viewLog.getString(1),viewLog.getString(2),viewLog.getString(3),viewLog.getString(4));
			}
			System.out.println("----------+-------------+-----------------+------------------------+\n");
		} catch (SQLException e) {
			System.err.println("DB query issue ");
		}
	}
	
	
	public void viewSms( String phone) {
		try {
			PreparedStatement viewSms;
			
			if(phone.length()>2) {
				 viewSms= connection.prepareStatement(String.format("select Contact.name,smslog.phone,smslog.sms,smslog.time from Contact right join smslog on Contact.phone = smslog.phone where smslog.phone='%s' order by time desc",phone));
			}
			else
				viewSms = connection.prepareStatement(String.format("select Contact.name,smslog.phone,smslog.sms,smslog.time from Contact right join smslog on Contact.phone = smslog.phone order by time desc"));

			ResultSet viewLog = viewSms.executeQuery();
			
             if(!viewLog.next()) {
				if(phone.length()>2){
				System.out.println("You haven't sent any Messages to this "+phone);
				System.out.println("Try sending one !!!");
				}else 
					System.out.println("No data ");
				return;
			}
             
			System.out.print  ("----------+-------------+------------------------+---------------------------+\n");
			System.out.println("   Name   |    Phone    |          Time          |            SMS            |");
			System.out.print  ("----------+-------------+------------------------+---------------------------+\n");
			System.out.printf("\n%-10s|%-13s|%-11s|%-22s|",viewLog.getString(1),viewLog.getString(2),viewLog.getString(4),viewLog.getString(3));

			while(viewLog.next()) {
				System.out.printf("\n%-10s|%-13s|%-11s|%-22s|",viewLog.getString(1),viewLog.getString(2),viewLog.getString(4),viewLog.getString(3));
			}
			System.out.println("----------+-------------+------------------------+---------------------------+\n");
		} catch (SQLException e) {
			System.err.println(" Query issue ");
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
				System.out.printf("\n%-10s|%-13s|%-11s|%-22s|",res.getString(1),res.getString(2),res.getString(3),res.getString(4));
			}
			System.out.println("\n----------+-------------+-----------+----------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String searchOne(String type,String search){
		String phone ="";
	try {
		PreparedStatement searchOne = connection.prepareStatement(String.format("SELECT * FROM Contact where %s='%s'",type,search));
		ResultSet res = searchOne.executeQuery();
		
		if(res.next()) {
			phone = res.getString(2);
			System.out.print  ("----------+-------------+-----------+----------------------+\n");
			System.out.println("   Name   |    Phone    |   Lable   |         Email        |");
			System.out.print  ("----------+-------------+-----------+----------------------+");
			System.out.printf("\n%-10s|%-13s|%-11s|%-22s|",res.getString(1),phone,res.getString(3),res.getString(4));
		}
		
		System.out.println("\n----------+-------------+-----------+----------------------+");
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return phone;
	}
	
	
	
	public void updateOne(String setType, String setVal, String type,String search) {
		
		try {
			PreparedStatement searchOne = connection.prepareStatement(String.format("UPDATE Contact set %s='%s'  where %s='%s'",setType,setVal,type,search));
			int res = searchOne.executeUpdate();
			if(res==1) {
				System.out.println("\n****** Contact updated & show it******\n");
				
				searchOne(setType,setVal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String table,String type, String phone) {
		try {
			PreparedStatement deleteOne = connection.prepareStatement(String.format("delete from %s where %s='%s'",table,type,phone));
			int result = deleteOne.executeUpdate();	
			if(result>=1)
				System.out.println("**********  deleted successfully   **********");
		} catch (SQLException e) {
			System.err.println("DB Query issues");
		}
		
	}
}
