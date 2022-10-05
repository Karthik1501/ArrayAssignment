package contactmanagement;

import java.sql.SQLException;

public class ContactManager {
	
	public void start() {
		System.out.println("*********************************************");
		System.out.println("             Contact Manager                 ");
		System.out.println("*********************************************");
		boolean flag = true;
		while (flag) {
			System.out.println("Choose before option -:)           ");
			System.out.println("\t1.AddContact\n\t2.ViewContact\n\t3.DeleteContact\n\t4.Quit ");
			ContactOperation op = new ContactOperation();
			
				switch(Validation.userChoice()) {
				case 1:
					op.AddContact();break;
				case 2:
					op.ViewContact();break;
				case 3:
					op.DeleteContact();break;
				case 4:
					System.out.println("!!! Thank for visiting !!!");
					flag=false;break;
			  default:
				  System.err.println("Try again !!!");
				  System.out.println("_________________________________________\n");
				  break;
				}
		}
	}
}
