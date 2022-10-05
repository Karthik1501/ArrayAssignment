package contactmanagement;

import java.sql.SQLException;

public class ContactOperation {
	
	 DatabaseController dbControll  ;
	 ContactOperation(){
		 try {
			dbControll = new DatabaseController();
		} catch (SQLException e) {
			
			System.err.println("DB Connection faild !!!");
		}
	 }
	
	public void AddContact()  {
		System.out.println("*********************************************");
		System.out.println("            Create new Contact !!!");
		System.out.println("*********************************************");
	
		String name =Validation.isValidName();			
		String phone =Validation.isValidPhoneNumber();
		String lable = Validation.isValidLable();
		String email = Validation.isValidEmail();
	
		dbControll.addContact(name, phone, lable, email);
		
	}
	
	public void ViewContact() {
		System.out.println("*********************************************");
		System.out.println("Choose before option -:)           ");
		System.out.printf("\t1.View All Contact\n\t2.Search Contact\n\t3.Back ");
		
		switch(Validation.userChoice()) {
		case 1:
			dbControll.viewAllContact();break;
		case 2:
			SearchOne();break;
		case 3:
			break;
		default:
				System.err.println("Invalid option !!!");
		}
		
	}
	
	public void SearchOne() {
		System.out.println("*********************************************");
		System.out.println("Search by \n\t1.Phone\n\t2.Name\n\t3.Email\n\t4.Back");
		String search ="",type="";
		switch(Validation.userChoice()) {
		case 1:{
			type = "Phone";
			search = Validation.isValidPhoneNumber();
		};break;
		case 2:{
			type = "Name";
			search = Validation.isValidName();
		};break;
		case 3:{
			type = "Email";
			search = Validation.isValidEmail();
		}break;
		case 4:break;
		default:
			System.err.println("Invalid choice !!!");
		}
		
		dbControll.searchOne(type,search);
		updateContact(type, search);
	}
	


	public void updateContact(String updateType,String updateVal) {
		System.out.println("*********************************************");
		System.out.println("Edit options -:) \n\t1.Phone\n\t2.Name\n\t3.Email\n\t4.Back");
		String editType ="", editVal="";
		switch(Validation.userChoice()) {
		case 1:{
			editType = "Phone";
			editVal = Validation.isValidPhoneNumber();
		};break;
		case 2:{
			editType= "Name";
			editVal = Validation.isValidName();
		};break;
		case 3:{
			editType = "Email";
			editVal = Validation.isValidEmail();
		}break;
		case 4:break;
		default:
			System.err.println("Invalid choice !!!");
		}
		dbControll.updateOne(editType, editVal, updateType, updateVal);
	}
	
	public void DeleteContact() {
		String phone=Validation.isValidPhoneNumber();
		dbControll.deleteContact(phone);
	}
}
