package contactmanagement;

import java.sql.SQLException;
import java.util.Scanner;

public class ContactOperation {
   Scanner sc = new Scanner(System.in);
	public static DatabaseController dbControll;

	ContactOperation() {
		try {
			dbControll = new DatabaseController();
		} catch (SQLException e) {

			System.err.println("DB Connection faild !!!");
		}
	}

	public void addContact() {
		System.out.println("*********************************************");
		System.out.println("            Create new Contact !!!");
		System.out.println("*********************************************");

		String name = Validation.isValidName();
		String phone = Validation.isValidPhoneNumber();
		String lable = Validation.isValidLable();
		String email = Validation.isValidEmail();

		dbControll.addContact(name, phone, lable, email);

	}

	public void addSms() {
		System.out.println("*********************************************");
		System.out.println("            Create new Contact !!!");
		System.out.println("*********************************************");

		String phone = Validation.isValidPhoneNumber();
		String sms = Validation.isValidLable();

		dbControll.sendSms(phone, sms);

	}

	public void viewContact() {
		dbControll.viewAllContact();
	}

	public void searchOne() {
		System.out.println("\n*********************************************");
		System.out.println("Search by \n\t1.Phone\n\t2.Name\n\t3.Email\n\t4.Back");
		String search = "", type = "";
		switch (Validation.userChoice()) {
		case 1: {
			type = "Phone";
			search = Validation.isValidPhoneNumber();
		}
			;
			break;
		case 2: {
			type = "Name";
			search = Validation.isValidName();
		}
			;
			break;
		case 3: {
			type = "Email";
			search = Validation.isValidEmail();
		}
			break;
		case 4:
			break;
		default:
			System.err.println("Invalid choice !!!");
		}

		String phone = dbControll.searchOne(type, search);
		doOperation("phone", phone);
	}

	private boolean doOperation(String type, String phone) {
		System.out.println("\n*********************************************");
		
		while (true) {
			System.out.println("Search by \n\t[1].Call\n\t[2].SMS\n\t[3].View SMS\n\t[4].View Call Hostory\n\t[5].Edit Contact\n\t[6].Delete Call History\n\t[7].Delete SMS\n\t[8].Back ");
			switch (Validation.userChoice()) {

			case 1:
				String duration = letsCall(phone);
				dbControll.addCallLog(phone, duration);
				break;

			case 2:
				String msg = getmsgformat();
				dbControll.sendSms(phone, msg);
				break;
			case 3:
				dbControll.viewSms(phone);
				break;
			case 4:
				dbControll.viewCallHistory(phone);
				break;
			case 5:
				updateContact(type, phone);
				break;
			case 6:
				dbControll.delete("callhirtory", type, phone);
				break;
			case 7:
				dbControll.delete("smslog", type, phone);
				break;
			case 8:
				return true;
			default:
				System.out.println("Choose correct option");
			}
		}
	}

	private String letsCall(String phone) {

		System.out.print("\nCalling to "+phone+"....");

		for (int i = 0; i < 5; i++) {
			System.out.print("..");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
        
		System.out.println("\n\tConnected....\n\n  Started recording");

		long start = System.currentTimeMillis();

		System.out.println("\nEnd Call :\n\t1.YES\n\t2.NO");

		runtime();

		long end = System.currentTimeMillis();

		long duration = end - start;

		long minutes = (duration / 1000) / 60, seconds = (duration / 1000) % 60;

		String min = String.valueOf(minutes) + " min " + String.valueOf(seconds) + " sec";

		System.out.println("Call duration : " + min);

		return min;
	}

	private void runtime() {

		while (!sc.hasNextInt()) {
		}
		int yes = sc.nextInt();

		if (yes != 1)
			runtime();
		else
			return;
	}

	private String getmsgformat() {

		System.out.print("Enter message :");
		String msg = sc.nextLine();

		if (msg.length() < 60)
			return msg;

		String[] chunks = msg.split("(?<=\\G.{60})");

		msg = "";
		for (String s : chunks)
			msg += s + "\n";

		return msg;

	}

	public void updateContact(String updateType, String updateVal) {
		System.out.println("*********************************************");
		System.out.println("Edit options -:) \n\t1.Phone\n\t2.Name\n\t3.Email\n\t4.Back");
		String editType = "", editVal = "";
		switch (Validation.userChoice()) {
		case 1: {
			editType = "Phone";
			editVal = Validation.isValidPhoneNumber();
		}
			;
			break;
		case 2: {
			editType = "Name";
			editVal = Validation.isValidName();
		}
			;
			break;
		case 3: {
			editType = "Email";
			editVal = Validation.isValidEmail();
		}
			break;
		case 4:
			break;
		default:
			System.err.println("Invalid choice !!!");
		}
		if (editType.length() != 0)
			dbControll.updateOne(editType, editVal, updateType, updateVal);
	}

	public void deleteContact() {
		String phone = Validation.isValidPhoneNumber();
		dbControll.delete("Contact","phone",phone);
	}
}
