package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class DatabaseController {
	Connection connection = null;
	Statement statement = null;
	LocalDate date = LocalDate.now();
	int day = date.getDayOfMonth(), month = date.getMonthValue(), year = date.getYear();

	public void addDataToDb(int query, String expenseType, double amount, String method) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalexpenses", "user1", "8621");
			statement = connection.createStatement();
			if (query == 0) {
				String queryexpense = String.format("INSERT INTO expensetable values('" + expenseType + "," + amount
						+ "," + date + "," + method + "','" + day + "," + month + "," + year + ")");
				statement.executeUpdate(queryexpense);
			} else {
				String queryeincome = String.format("INSERT INTO incometable values('" + expenseType + "," + amount + ","
						+ date + "," + method + "," + day + "," + month + "," + year + ")");
				statement.executeUpdate(queryeincome);
			}
			System.out.println("Success...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet searchTransactionDb(int value,int year ) {
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalexpenses", "user1", "8621");
			statement = connection.createStatement();
			if (value == 2) {
				System.out.println("****************** you are  Expense  ****************** ");
				String sql = String.format("Select * from expensetable where year='" +year+ "' ");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			} 
			else if(value==1){
				System.out.println("****************** your are Income  ******************");
				System.out.println("income");
				String sql = String.format("Select * from incometable where year='" +year+ "' ");
				resultSet= statement.executeQuery(sql); 
				return resultSet;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public ResultSet searchTransactionDb(int value,int month,int year ) {
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalexpenses", "user1", "8621");
			statement = connection.createStatement();
			if (value == 2) {
								String sql = String.format("Select * from expensetable where month='"+month+"'AND year='"+year+"'");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			} 
			else if(value==1){
				
				String sql = String.format("Select * from incometable where month='"+month+"'AND year='"+year+"'" );
				resultSet= statement.executeQuery(sql);
				return resultSet;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

	public ResultSet searchTransactionDb(int value,int date,int month,int year ) {
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalexpenses", "user1", "8621");
			statement = connection.createStatement();
			if (value == 2) {
				System.out.println("\t\t\t***** You are Searching For Expense *****");
				String sql = String.format("Select * from expensetable where day='"+date+"'AND month='"+month+"'AND year='"+year+"'");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			} else if(value==1)
			{
				System.out.println("\t\t\t***** You are Searching For Income *****");
				String sql = String.format("Select * from incometable where day='"+date+"'AND month='"+month+"'AND year='"+year+"'");
				resultSet= statement.executeQuery(sql);
				return resultSet;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}
}
