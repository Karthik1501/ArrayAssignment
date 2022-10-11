package bankapplication;

public class LoanProcess extends Admin{
	long loanNumber = 102001;
	User currentUser;
	double getLoanAmount;
	public void loanProcess() throws InterruptedException {
		System.out.println("--------- Apply personal loan get instance money  -----------");
		while (true) {
			System.out.println("\nIf you already customer in in this bank [Y/N] ?\n");
			
			char checkCustomer = Validation.sc.next().charAt(0);

			if (checkCustomer == 'Y' || checkCustomer == 'y') {
				if(cibilEligiblity())
					if(checkMaintainMinimumBalance())
						if(loanSanction());
				
						else
							break;
					else
						break;
				else
					break;

			} else if (checkCustomer == 'N' || checkCustomer == 'n') {
				System.out.println("!!!! Please sign up first !!!!");
				new BankManagement().addUser();
			} else
				System.out.println("Invalid input try again !!!!");

		}
	}
	
	 boolean cibilEligiblity() throws InterruptedException {
		 
		String currentCustomer = LoginAthentication.isUser();
		
		 currentUser = BankManagement.users.get(currentCustomer);
		System.out.println("\nChecking your cibil score \n");
		Thread.sleep(2000);
		 if(currentUser.getCibil() >=750) {
			 System.out.println("\nChecking if your already get loan or not");
			 Thread.sleep(4000);
			 if(!currentUser.isLoanFlag()) 
				 return true;
				else
				 System.out.println("\nwe are say sorry your already get loan\n");
		 }
		 else
				System.out.println("Your cibil is low so your not eligible ");
				 return false;
		
			 
	}
	
	 boolean checkMaintainMinimumBalance() throws InterruptedException {
		 System.out.println("\nChecking your minimum maintain balance \n");
		 Thread.sleep(4250);
		 if(currentUser.getLoanEligibilityAmount() >=0) {
			 return true;
		 }
		 else {
			 System.out.println("\nwe are say sorry your minimum maintain balance is low \n");
             return false;
		 }

	 }
	  
	 boolean loanSanction() throws InterruptedException {
		 System.out.println("Your eligible loan amount Rs.40000 \n");
		 Thread.sleep(5700);
		 System.out.println("If you intrested countinue [Y/N] :");
		 while(true) {
		 char checkCustomer = Validation.sc.next().charAt(0);
			if (checkCustomer == 'Y' || checkCustomer == 'y') {
				currentUser.setLoanFlag(true);
				double amount = getBankAmount();
				System.out.println("Enter loan amount (minimum Rs.20000)");
				getLoanAmount = Validation.sc.nextDouble();
				
				if(getLoanAmount >= 20000 && getLoanAmount <= 40000) {
				
				double emiCalculation = getLoanAmount * 0.011667 *(1+0.011667)*24 / ((1+0.011667)*24-1);
				double totalPay = getLoanAmount+emiCalculation*24;
				System.out.println("\n-----------------------------------------------------------------------------\n");
				System.out.printf("\nMonthly EMI : %-7.2f Total Year : 2     Total Payment : %.2f",emiCalculation,totalPay);
				System.out.println("\n-----------------------------------------------------------------------------\n");
				setBankAmount(amount - getLoanAmount);
				double loanProces =getLoanAmount-(getLoanAmount*2/100);
				System.out.printf("\nLoan Processing Charge @ 2 percent = %.2f",loanProces);
				double docCharge=loanProces-500;
				System.out.println("\nDocumentation Charge Rs.500 = "+ docCharge+"\n");
				Thread.sleep(3000);
				System.out.println("\nSuccessfully credited in your Bank\n");
				currentUser.setBalance(currentUser.getBalance()+docCharge);
				
				MoneyOperation.recordHistory( currentUser.getEmail(), "Personal Loan Rs.", docCharge);
				
				userLoan.put(currentUser.getAcNumber(),(new Loan(currentUser.getName(),"Personal Loan",++loanNumber,currentUser.getAcNumber(),getLoanAmount,totalPay,emiCalculation, 14)));
				return false;
				}
				else if(getLoanAmount <=20000)
					System.out.println("Sorry Minimum Loan Rs.20000");
				else
					System.out.println("Sorry entered amount is too high ");
				
			} else if (checkCustomer == 'N' || checkCustomer == 'n') {
				System.out.println("         Back to Main         ");
				return false;
			}
			 else
				System.out.println("Invalid input try again !!!!");
		 }
			//
			 
			 
	 }
	
}
