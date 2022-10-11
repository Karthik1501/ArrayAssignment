package controler;

import java.time.LocalDate;
import model.IncomeTransaction;
public class IncomeController {
	 double totalIncomeAmount;
	
	IncomeTransaction incomeTransaction=new IncomeTransaction();
	DatabaseController databaseController = new DatabaseController();
	LocalDate date=LocalDate.now();
	public void addIncome(String inputincome,double amount,String method) {
		incomeTransaction.setIncomeType(inputincome);
		incomeTransaction.setIncomeAmount(amount);
		incomeTransaction.setPaymentMethod(method);
		addDatebase();
	}
	private void addDatebase() {
		databaseController.addDataToDb(1,incomeTransaction.getIncomeType(), incomeTransaction.getIncomeAmount(),
		 incomeTransaction.getPaymentMethod());
	}
	
}
