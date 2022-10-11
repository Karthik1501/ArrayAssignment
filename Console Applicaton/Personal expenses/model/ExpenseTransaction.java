package model;

public class ExpenseTransaction {
	private double expenseAmount,expenseTotalAmount;
	private String expenseType;
	private String paymentMethod;
	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getExpenseTotalAmount() {
		return expenseTotalAmount;
	}

	public void setExpenseTotalAmount(double expenseTotalAmount) {
		this.expenseTotalAmount = expenseTotalAmount;
	}

}