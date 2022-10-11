package contactmanagement;

import java.sql.SQLException;

public class ContactManager {

	public void start() {
		System.out.println("*********************************************");
		System.out.println("             Contact Manager                 ");
		System.out.println("*********************************************");
		while (true) {
			System.out.println("\nChoose before option -:)           ");
			System.out.println("\n\t[1].AddContact\n\t[2].ViewAllContact\n\t[3].View CallLog\n\t[4].View All SMS\n\t[5].SearchContact\n\t[6].DeleteContact\n\t[7].Quit ");
			ContactOperation crudOperation = new ContactOperation();

			switch (Validation.userChoice()) {
			case 1:
				crudOperation.addContact();
				break;
			case 2:
				crudOperation.viewContact();
				break;
			case 3:
				 ContactOperation.dbControll.viewCallHistory("");
				 break;
			case 4:
				 ContactOperation.dbControll.viewSms("");
				 break;
			case 5:
				crudOperation.searchOne();
				break;
			case 6:
				crudOperation.deleteContact();
				break;
			case 7:
				System.out.println("!!! Thank for visiting !!!");
				System.exit(0);
			default:
				System.err.println("              Try again !!!");
				System.out.println("_________________________________________\n");
			}
		}
	}
}
