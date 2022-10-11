package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserOperation {	
	Scanner sc = new Scanner(System.in);
	
	
	UserOperation(){

		existingUser();
	}
	
	public void existingUser() {
		System.out.println("********* User Login *********\n");
		
		LoginAthentication authToken = new LoginAthentication();
		//System.out.println(users.keySet());
		String auth = authToken.isUser();
		while (auth.length()!=0) {
			System.out.println("\nChoose option -:) ");
			System.out.println("\t[1].A/C information\n\t[2].Deposit\n\t[3].Withdraw\n\t[4].OnlineTransaction\n\t[5].View Loan Info\n\t[6].TransactionHistory\n\t[7].Logout");
			byte option = Validation.userChoice();

			User currentUser = BankManagement.users.get(auth);
			
			MoneyOperation moneyOp = new MoneyOperation(currentUser);
			switch (option) {
			case 1:
				System.out.println(currentUser);
				break;
			case 2:
				moneyOp.addMoney();
				break;
			case 3:
				moneyOp.withDrawMoney();
				break;
			case 4:
				new OnlineTransaction(currentUser);
				break;
			case 5:
				new Admin().displayLoanInfo(currentUser.getAcNumber());break;
			case 6:
				MoneyOperation.displayHistory(currentUser.getEmail());break;
			case 7:auth="";break;
			default :
				System.err.println("Invalid input try again !!!!");
			}
			
		}
	}
}
