package bankapplication;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OnlineTransaction {
	Scanner sc = new Scanner(System.in);
	HashMap<String, User>users;
	HashMap<Long, String> acTransfer;
	User temp;
	double reqMoney;
	double fromMoney;
	OnlineTransaction(User p,HashMap<String, User>users,HashMap<Long, String>at){
		temp = p;
		acTransfer = at;
		this.users = users;
		Transaction();
	}
	private void Transaction() {
		System.out.println("_________________________________________\n");
		System.out.println("Welcome to online banking");
		System.out.println("_________________________________________\n");
		boolean flag = true;
		while(flag) {
		System.out.println("1.UPI\n2.A\\C 2 A\\C\n3.Back");
		byte userChoice = Validation.userChoice();
		switch(userChoice) {
		case 1:UpiTransaction();break;
		case 2:BankTransaction();break;
		case 3:flag=false;break;
		default:System.err.println("Invalid try again !!!");break;
		}
		}
	}
	
	
	private void UpiTransaction() {
		System.out.println("_________________________________________\n");
		System.out.println("Your A\\C balance Rs."+temp.getBalance());
		System.out.println("From UPI "+temp.getEmail());
		System.out.println("To  UPI (Email) :");
		//sc.nextLine();
		String toUpi = sc.nextLine();
		if(users.containsKey(toUpi)) {		
			User toUser = users.get(toUpi);
			reqMoney = Validation.isValidMoney();
			fromMoney = temp.getBalance();
			if(reqMoney<=fromMoney) {
				 MoneyOperation.recordHistory(temp.getEmail(), "UPI transaction ", reqMoney);
				 MoneyOperation.recordHistory(toUser.getEmail(), "UPI transaction ", reqMoney);
				 
				 toUser.setBalance(reqMoney + toUser.getBalance());
				 System.out.println("Money transfered successfully -:)");
				 temp.setBalance(fromMoney - reqMoney);
			}
		}else
			System.out.println("Invalid To(Email) UPI !!");
	}
    private void BankTransaction() {
    	System.out.println("_________________________________________\n");
		System.out.println("Your A\\C balance Rs."+temp.getBalance());
		System.out.println("From your A\\C.No "+temp.getAcNumber());
		System.out.print("Enter To A\\C.No :");
		long toAc = sc.nextLong();
		if(acTransfer.containsKey(toAc)) {	
			String username =acTransfer.get(toAc);
			User toUser = users.get(username);
			reqMoney = Validation.isValidMoney();
			fromMoney = temp.getBalance();
			if(reqMoney<=fromMoney) {
				MoneyOperation.recordHistory(temp.getEmail(), "A\\C 2 A\\C transaction ", reqMoney);
				 MoneyOperation.recordHistory(toUser.getEmail(), "A\\C 2 A\\C transaction  ", reqMoney);
				 toUser.setBalance(reqMoney+toUser.getBalance());
				 
				 System.out.println("Money transfered successfully -:)");
				 temp.setBalance(fromMoney - reqMoney);
				 System.out.println("_________________________________________\n");
			}
		}else
			System.out.println("Invalid A\\C number !!!");
		System.out.println("_________________________________________\n");
	}
}
