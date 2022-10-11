package bankapplication;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OnlineTransaction {
	Scanner sc = new Scanner(System.in);
	User currentUser;
	double reqMoney;
	double fromMoney;
	OnlineTransaction(User user){
		currentUser = user;
		transaction();
	}
	private void transaction() {
		System.out.println("_________________________________________\n");
		System.out.println("Welcome to online banking");
		System.out.println("_________________________________________\n");
		boolean flag = true;
		while(flag) {
		System.out.println("\t[1].UPI\n\t[2].A\\C 2 A\\C\n\t[3].Back");
		byte userChoice = Validation.userChoice();
		switch(userChoice) {
		case 1:upiTransaction();break;
		case 2:bankTransaction();break;
		case 3:flag=false;break;
		default:System.err.println("Invalid try again !!!");break;
		}
		}
	}
	
	
	private void upiTransaction() {
		System.out.println("_________________________________________\n");
		System.out.println("Your A\\C balance Rs."+currentUser.getBalance());
		System.out.println("From UPI "+currentUser.getEmail());
		System.out.println("To  UPI (Email) :");
		//sc.nextLine();
		String toUpi = sc.nextLine();
		if(BankManagement.users.containsKey(toUpi)) {		
			User toUser = BankManagement.users.get(toUpi);
			reqMoney = Validation.isValidMoney();
			fromMoney = currentUser.getBalance();
			if(reqMoney<=fromMoney) {
				 MoneyOperation.recordHistory(currentUser.getEmail(), "UPI transaction ", reqMoney);
				 MoneyOperation.recordHistory(toUser.getEmail(), "UPI transaction ", reqMoney);
				 
				 toUser.setBalance(reqMoney + toUser.getBalance());
				 System.out.println("Money transfered successfully -:)");
				 currentUser.setBalance(fromMoney - reqMoney);
			}
		}else
			System.out.println("Invalid To(Email) UPI !!");
	}
    private void bankTransaction() {
    	System.out.println("_________________________________________\n");
		System.out.println("Your A\\C balance Rs."+currentUser.getBalance());
		System.out.println("From your A\\C.No "+currentUser.getAcNumber());
		System.out.print("Enter To A\\C.No :");
		long toAccount = sc.nextLong();
		if(toAccount != currentUser.getAcNumber()) {
			
		if(BankManagement.accountTransfer.containsKey(toAccount)) {
			System.out.println("Enter IFSC CODE: ");
			sc.nextLine();
			String toUserIFSC =sc.nextLine();
			if(BankManagement.IFSC.equals(toUserIFSC)) {
			String toUserEmail =BankManagement.accountTransfer.get(toAccount);
			User toUser = BankManagement.users.get(toUserEmail);
			reqMoney = Validation.isValidMoney();
			fromMoney = currentUser.getBalance();
			if(reqMoney<=fromMoney) {
				String history =  "From self To *****"+toUser.getAcNumber()%10000;
				MoneyOperation.recordHistory(currentUser.getEmail(),history, reqMoney);
				String toHistory =  "From *****"+currentUser.getAcNumber()%10000+" to self ";
				 MoneyOperation.recordHistory(toUser.getEmail(), toHistory, reqMoney);
				 toUser.setBalance(reqMoney+toUser.getBalance());
				 
				 System.out.println("Money transfered successfully -:)");
				 currentUser.setBalance(fromMoney - reqMoney);
				 System.out.println("_________________________________________\n");
			}
		  }
			else
				System.out.println("Ivalid IFSC CODE try again");
		}else
			System.out.println("Invalid A\\C number !!!");
		}
		else
			System.out.println("Please try  to enter other Acoount number ");
		System.out.println("_________________________________________\n");
	}
}
