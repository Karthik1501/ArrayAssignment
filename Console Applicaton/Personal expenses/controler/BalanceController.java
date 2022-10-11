package controler;

import java.sql.ResultSet;
import java.time.LocalDate;

public class BalanceController {
	DatabaseController databaseController =new DatabaseController();
	LocalDate date=LocalDate.now();
	ResultSet resultSet;
	double[] result=new double[4];
	
	public double[] showBalance() {
		result[0]=searchTransaction(1,date.getMonthValue(),date.getYear());
		result[1]=searchTransaction(2,date.getMonthValue(),date.getYear());	
		return result;
	}
	public double searchTransaction(int value, int month,int year) {
		resultSet=databaseController.searchTransactionDb(value,month,year);
		double totalAmount=0;
		try
		{
			double Amount;
			while(resultSet.next()) {
		           Amount=resultSet.getDouble(2);
		           totalAmount+=Amount;
			}
		}
		catch(Exception e) {
			
		}
		return totalAmount; 
	}
	
}
