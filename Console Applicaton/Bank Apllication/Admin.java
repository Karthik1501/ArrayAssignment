package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Admin {
	private double bankAmount = 100000000;
	static HashMap<Long,Loan> userLoan = new HashMap<>();
	void bankAdmin() {
		
		LoginAthentication  adminAuth = new LoginAthentication();
		System.out.println("************* Admin Login *************\n");
		String auth= adminAuth.isAdmin();
		while(!auth.isEmpty()) {
		if(auth.length()!=0) {
			System.out.println("_________________________________________\n");
			System.out.println("-------> Welcome Admin Dashboard <--------");
			System.out.println("_________________________________________\n");
			System.out.println("Enter option :");
			System.out.println("\t[1].View customer details\n\t[2].Loan Approved\n\t[3]sBack");
			byte b =Validation.userChoice();
			if(b==1) {
				System.out.println("_________________________________________\n");
				System.out.println("   Total Account in this branch :"+"\t"+BankManagement.users.size());
				System.out.println("_________________________________________\n");
				for(Entry<String, User> users:BankManagement.users.entrySet()) {
					//System.out.println(temp.getKey());
					System.out.println( users.getValue());
				}
		   }
			else if(b == 2)
				 break;
			else
				System.err.println("Invalid input try again !!!");
	        }
		
	    }
		
	}
	
	public void displayLoanInfo(long acNumber) {
		Loan loan = userLoan.get(acNumber);
		System.out.println("\n---------------------------------------"+
		        "\n    Name              :"+loan.getName()+
				"\n    Loan Type         :"+loan.getLoanType()+
				"\n    Loan Number       :"+loan.getLoanNumber()+
				"\n    A/C No            :"+loan.getAccountNumber()+
				"\n    Sanction Amount   :"+loan.getLoanSanctionAmount()+
				"\n    Total Payment     :"+loan.getTotalPayment()+
				"\n    Due Amount        :"+loan.getDueAmount()+
				"\n    Inte rest         :"+loan.getInterest()+
				"\n---------------------------------------"
				
				);
		
	}
	

	public double getBankAmount() {
		return bankAmount;
	}
	public void setBankAmount(double bankAmount) {
		this.bankAmount = bankAmount;
	}
	
	
	
}
