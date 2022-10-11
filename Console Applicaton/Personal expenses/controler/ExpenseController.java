package controler;
import model.ExpenseTransaction;

public class ExpenseController {
	ExpenseTransaction expenseTransaction = new ExpenseTransaction();
	DatabaseController databaseController = new DatabaseController();
	public void addExpense(String inputExpese, double amount, String method) {
		expenseTransaction.setExpenseType(inputExpese);
		expenseTransaction.setExpenseAmount(amount);
		expenseTransaction.setPaymentMethod(method);
		addToDatabase();
		
	}
	private void addToDatabase() {
		
		databaseController.addDataToDb(0,expenseTransaction.getExpenseType(), expenseTransaction.getExpenseAmount(),
				expenseTransaction.getPaymentMethod());
	}

}
