package view;

import java.util.Scanner;
import controler.IncomeController;
import controler.BalanceController;
import controler.ExpenseController;
import controler.TransactionController;

public class FunctionView {
	private int inputOption;
	Scanner scanner = new Scanner(System.in);
	private IncomeView incomeView;
	private ExpenseView expenseView;
	private BalanceView balanceView;
	private TransactionView transactionView;

	public FunctionView() {
		incomeView = new IncomeView();
		expenseView = new ExpenseView();
		balanceView = new BalanceView();
		transactionView = new TransactionView();
	}

	public void mainMenu() {
		try {
			System.out.println("Enter the option -:)");
			System.out.println("\t\t**********************");
			System.out.println("\t\t1.Add Expense");
			System.out.println("\t\t2.Add Income ");
			System.out.println("\t\t3.Blanace View");
			System.out.println("\t\t4.Transaction View");
			System.out.println("\t\t5.Exit");
			System.out.println("\t\t**********************");
			
			while(!scanner.hasNextInt())
		       {
			       System.out.println("Invalid Key.Enter again :");
			       scanner.nextLine();
		       }
			inputOption=scanner.nextInt();
			switch (inputOption) {
			case 1:
				expenseView.showExpenseList();
				mainMenu();
				break;
			case 2:
				incomeView.ShowIncomeView();
				mainMenu();
				break;
			case 3:
				balanceView.showBalance();
				mainMenu();
				break;
			case 4:
				transactionView.showTransation();
				mainMenu();
				break;
			case 5:
				System.out.println("Hava a good day.....");
				System.exit(0);
				break;
			default:
				System.out.println("!Invalid key!");
				mainMenu();
				break;				
			}
		} catch (Exception e) {
			System.out.println("!Invalid key!");
			mainMenu();
			return ;
		}

	}

}
