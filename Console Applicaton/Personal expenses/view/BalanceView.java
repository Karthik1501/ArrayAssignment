package view;

import controler.BalanceController;

public class BalanceView {
	BalanceController balanceController=new BalanceController();
	double[] results=new double[4];
	public void showBalance() {
		System.out.println("\t\t****This Month Balance****");
		results=balanceController.showBalance();
		System.out.println("\t**********************************************");
		System.out.println("\t This Month Total Income Is ---->   Rs."+results[0]);
		System.out.println();
		System.out.println("\t This Month Total Expense Is --->   Rs."+results[1]);
		System.out.println("\t-----------------------------------------------");
		System.out.println("\t\t\t\tBalance Is RS.("+(results[0]-results[1])+")");
		if((results[0]-results[1])<1) {
			System.out.println("\t Your Expenses Cross Over than Your Income Try For Save Money...");
		}
		System.out.println("\t-----------------------------------------------");
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
