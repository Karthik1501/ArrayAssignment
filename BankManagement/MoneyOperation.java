package bankapplication;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MoneyOperation {

Scanner sc = new Scanner(System.in);
  User b;
  private static HashMap<String, List<TransactionHistory>> transaction = new HashMap<>();  
  
  NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en","in"));
  
  static LocalDateTime myDateObj = LocalDateTime.now();  
  static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
  static String formattedDate = myDateObj.format(myFormatObj);  
 
  
  MoneyOperation(User temp){
	  
	  b = temp;
  }
 
	public void addMoney() {
		System.out.println("_________________________________________\n");
		System.out.println("Current balance :"+format.format(b.getBalance()).substring(1));
			double depositeAmount = Validation.isValidMoney();
			if(depositeAmount > 100) {
				recordHistory(b.getEmail(), "Money deposit Rs", depositeAmount);
				depositeAmount =b.getBalance()+depositeAmount;
				b.setBalance(depositeAmount);
				 
				 System.out.println("Current balance :"+format.format(b.getBalance()).substring(1));
				 System.out.println("Successfully deposited !!!");
				 System.out.println("_________________________________________\n");
			}
			else
			  System.out.println("Deposit Amount must be Above Rs.500/- ");
	}
	
	
	
	public void withDrawMoney() {
		System.out.println("_________________________________________\n");
		double tempBalance = b.getBalance();
		if(tempBalance>0) {
			System.out.println("Before Current balance :"+format.format(tempBalance).substring(1));
		    double withDraw = Validation.isValidMoney();
		    if(tempBalance >= withDraw) {
		    	tempBalance = tempBalance - withDraw;
		    	b.setBalance(tempBalance);
		    	recordHistory( b.getEmail(), "Money debited Rs", withDraw);
		    	System.out.println("Current balance :"+format.format(tempBalance).substring(1));
		    
		    }
		    else
		    	System.out.println("Insufficent balance !!!");
		}
		else {
			System.out.println("Your balance is too low Rs.0:-)");
		}
			
	}
	
	
	

	 public static void recordHistory(String email,String transactionType, double amount)
	  {
		 
		// System.out.printf(transactionType,email, amount);
		  if(transaction.containsKey(email)) {
				 transaction.get(email).add(new TransactionHistory( transactionType, amount, formattedDate));
			 }
		  
		  ArrayList<TransactionHistory> transaction_array = new ArrayList<>();
		  transaction_array.add(new TransactionHistory( transactionType, amount, formattedDate));
	        transaction.putIfAbsent(email, transaction_array);
		 
	  }

	public static void displayHistory(String email) {
		List<TransactionHistory> t = transaction.get(email);
		System.out.println(t);
	}
	

}
