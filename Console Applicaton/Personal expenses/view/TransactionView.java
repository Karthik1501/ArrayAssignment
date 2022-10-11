package view;
import java.util.Scanner;
import controler.TransactionController;
public class TransactionView {
	int inputOption, searchDate, searchMonth, searchYear;
	Scanner scanner = new Scanner(System.in);
	TransactionController transactionController=new TransactionController();
	public void showTransation() {
		System.out.println("Chose the Transaction");
		System.out.println("1.Income Transaction");
		System.out.println("2.Expense Transaction");
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid Key.Enter again :");
			scanner.nextLine();
		}
		inputOption = scanner.nextInt();
		if (inputOption > 0 && inputOption < 3) {
			switch (inputOption) {
			case 1:
				transactionOptions(1);
				break;
			case 2:
				transactionOptions(2);
				break;
			}
		} else {
			System.out.println("!Invalid input");
			showTransation();
		}
	}
	public void transactionOptions(int value) {

		System.out.println("1.Day search");
		System.out.println("2.Month search");
		System.out.println("3.Year search");
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid Key.Enter again :");
			scanner.nextLine();
		}
		inputOption = scanner.nextInt();
		if (inputOption > 0 && inputOption < 4) {
			switch (inputOption) {
			case 1:
				System.out.println("Enter the Date");
				searchDate = scanner.nextInt();
				System.out.println("Enter the month");
				searchMonth = scanner.nextInt();
				System.out.println("Enter the year");
				searchYear = scanner.nextInt();
				transactionController.searchTransaction(value,searchDate,searchMonth,searchYear);
				break;
			case 2:
				System.out.println("Enter the month");
				searchMonth = scanner.nextInt();
				System.out.println("Enter the year");
				searchYear = scanner.nextInt();
				transactionController.searchTransaction(value,searchMonth,searchYear);
				break;
			case 3:
				System.out.println("Enter the year");
				searchYear = scanner.nextInt();
				transactionController.searchTransaction(value,searchYear);
				break;
			}
		} else {
			System.out.println("!Invalid key");
			transactionOptions(value);
		}
	}
}
