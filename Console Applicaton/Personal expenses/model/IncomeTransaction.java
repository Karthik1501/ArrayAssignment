package model;

public class IncomeTransaction {
	private double incomeAmount,incomeTotalAmount;
	private	String incomeType;
	private String paymentMethod;
	
	public double getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public double getIncomeTotalAmount() {
		return incomeTotalAmount;
	}
	public void setIncomeTotalAmount(double incomeTotalAmount) {
		this.incomeTotalAmount = incomeTotalAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
