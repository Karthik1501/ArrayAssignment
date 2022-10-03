package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserOperation {	
	Scanner sc = new Scanner(System.in);
	
	HashMap<String, User> users;
	HashMap<Long, String> acTransfer;
	HashMap<String, List<String>> transactionHistory;
	
	UserOperation(HashMap<String, User>users, HashMap<Long, String> acTrans){
		this.users = users;
		acTransfer = acTrans;
		existingUser();
	}
	
	public void existingUser() {
		System.out.println("_________________________________________\n");
		
		LoginAthentication authToken = new LoginAthentication();
		//System.out.println(users.keySet());
		String auth = authToken.isUser(users);
		while (auth.length()!=0) {
			System.out.println("Choose option -:) ");
			System.out.println("_________________________________________\n");
			System.out.println("1.A/C information\n2.Deposit\n3.Withdraw\n4.OnlineTransaction\n5.TransactionHistory\n6.Logout");
			byte option = Validation.userChoice();
			if(option>0 && option<=6) {
			User temp = users.get(auth);
			MoneyOperation moneyOp = new MoneyOperation(temp);
			switch (option) {
			case 1:
				System.out.println(temp);
				break;
			case 2:
				moneyOp.addMoney();
				break;
			case 3:
				moneyOp.withDrawMoney();
				break;
			case 4:{
				new OnlineTransaction(temp,users,acTransfer);
				break;
			}
			case 5:MoneyOperation.displayHistory(temp.getEmail());break;
			case 6:
				auth="";
			}
			}else
				System.err.println("Invalid input try again !!!!");
			}

	}
	
}
