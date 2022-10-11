package view;
import java.util.Scanner;
import controler.ExpenseController;
public class ExpenseView {
	ExpenseController expenseController=new ExpenseController();
	Scanner scanner = new Scanner(System.in);
	
	public void showExpenseList() {
		System.out.println("Enter the ExpenseType");
		String inputExpense=scanner.next();
		System.out.println("Enter the Amount");
		double amount=scanner.nextDouble();
		System.out.println("Enter the Payment Method");
		String method=scanner.next();
		expenseController.addExpense(inputExpense,amount,method);
	}
}
