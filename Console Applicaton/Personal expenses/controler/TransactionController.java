package controler;

import java.sql.ResultSet;

import view.FunctionView;

public class TransactionController {
	DatabaseController databaseController = new DatabaseController();
	
	ResultSet resultSet=null;
	  
	public void searchTransaction(int value,int year) {
		resultSet=databaseController.searchTransactionDb(value,year);
		printResultSet(resultSet,value);
	}

	public void searchTransaction(int value, int month,int year) {
		resultSet=databaseController.searchTransactionDb(value,month,year);
		printResultSet(resultSet,value);
	}

	public void searchTransaction(int value, int date,int month,int year) {
		resultSet=databaseController.searchTransactionDb(value,date,month,year);
		printResultSet(resultSet,value);
	}
	
	public void printResultSet(ResultSet resultSet,int value) {
		if(value==2) {
			try {
				   System.out.println("******************************************************************************************");
		           System.out.println("ExpenseType\t\tExpenseAmount\t\tDate\t\tExpensmethod");
		           System.out.println("------------------------------------------------------------------------------------------");
		           double totalexpenseAmount = 0;
		           while(resultSet.next()) {

		           totalexpenseAmount+=resultSet.getDouble(2);
		       
		           System.out.println(resultSet.getString(1)+"\t\t"+resultSet.getDouble(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4));
		        }
		         System.out.println("******************************************************************************************");
				 System.out.println("\t\t\tTotal Expense Amount Is:RS."+totalexpenseAmount);
				 System.out.println("------------------------------------------------------------------------------------------");
				 Thread.sleep(6000);
			}catch(Exception e)
			{
				System.out.println(e);
			}

		}else {
			try {
				   System.out.println("******************************************************************************************");
		           System.out.println("IncomeType\t\tIncomeAmount\t\tDate\t\tIncomeMethod");
		           System.out.println("------------------------------------------------------------------------------------------");
		           double totalexpenseAmount = 0;
		           while(resultSet.next()) {

		           totalexpenseAmount+=resultSet.getDouble(2);
		           System.out.println(resultSet.getString(1)+"\t\t"+resultSet.getDouble(2)+"\t\t"+resultSet.getString(3)+"\t\t"+resultSet.getString(4));
		        }
				System.out.println("******************************************************************************************");
				System.out.println("\t\t\t  Total Income Aomunt Is:RS."+totalexpenseAmount);
				System.out.println("------------------------------------------------------------------------------------------");
				Thread.sleep(6000);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		
	}

}
