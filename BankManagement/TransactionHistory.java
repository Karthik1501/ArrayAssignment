package bankapplication;

import java.util.HashMap;
import java.util.List;

public class TransactionHistory {
	private double amount;
	private String date, transferType;
	
	TransactionHistory(String transactionType, double amount, String date){
		this.amount = amount;
		transferType = transactionType;
		this.date = date;
	}
	
	public String toString() {
		return ("Date :"+ date+"\nTransactionType\t :" + transferType+" Amount :" + amount+"\n_________________________________________\n");
		
		
	}

	
	
}
