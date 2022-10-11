package bankapplication;


public class TransactionHistory {
	private double amount;
	private String date, transferType;
	private int transactionId;
	
	TransactionHistory(String transactionType, double amount, String date, int transactionId){
		this.amount = amount;
		transferType = transactionType;
		this.date = date;
		this.transactionId = transactionId;
	}
	
	public String toString() {
		return ("TransactionID :"+transactionId+"\tDate :"+ date+"\tTransactionType :" + transferType+"\tRs." + amount+"\n");
		
		
	}

	
	
}
