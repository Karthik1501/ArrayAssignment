package view;

import java.util.Scanner;
import controler.IncomeController;
public class IncomeView {
	IncomeController incomeController =new IncomeController();
	Scanner scanner = new Scanner(System.in);
	public void ShowIncomeView() {
		System.out.println("Enter the IncomeType: ");
		String inputIncome=scanner.next();
		System.out.println("Enter the Amount");
		double amount=scanner.nextDouble();
		System.out.println("Enter the Payment Method");
		String method=scanner.next();
		incomeController.addIncome(inputIncome,amount,method);
	}
}
