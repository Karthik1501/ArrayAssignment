package bankapplication;

public class Loan {
	private String name, loanType;
	private long loanNumber,accountNumber;
	private double loanSanctionAmount,totalPayment;
    private double dueAmount,interest;
    
    Loan(String name,String loanType, long loanNumber, long accountNumber,double loanSanctionAmount,double totalPayment,double dueAmount,double interest){
    	this.name = name;
    	this.loanType =loanType;
    	this.loanNumber = loanNumber;
    	this.accountNumber = accountNumber;
    	this.loanSanctionAmount = loanSanctionAmount;
    	this.totalPayment = totalPayment;
    	this.dueAmount = dueAmount;
    	this.interest =interest;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanSanctionAmount() {
		return loanSanctionAmount;
	}
	public void setLoanSanctionAmount(long loanSanctionAmount) {
		this.loanSanctionAmount = loanSanctionAmount;
	}
	
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public long getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(long loanNumber) {
		this.loanNumber = loanNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	
	
	public String toString() {
		return ("\n---------------------------------------------"+"\n     Account Information "+
		"\n---------------------------------------------"+
		"\n    Name              :"+getName()+
		"\n    Loan Type         :"+getLoanType()+
		"\n    Loan Number       :"+getLoanNumber()+
		"\n    A/C No            :"+getAccountNumber()+
		"\n    Sanction Amount   :"+getLoanSanctionAmount()+
		"\n    Total Payment     :"+getTotalPayment()+
		"\n    Due Amount        :"+getDueAmount()+
		"\n    Inte rest         :"+getInterest()+
		"\n--------------------------------------------");
		
		
		
	}
}
