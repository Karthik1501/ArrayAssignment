package bankapplication;


import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class BankManagement {
  static Scanner sc = new Scanner(System.in);
  final static String IFSC = "ZBANK007";
  static long autoGenareteAcNumber = 100001010;
  
  public static HashMap<String, User> users = new HashMap<>();
  public static HashMap<Long, String> accountTransfer = new HashMap<>();
  
  BankManagement(){
	  users.put("aji@gmail.com", (new User("Aji", "aji@gmail.com", "9087654321", "Male", "aji@123",(byte) 25, 12000,IFSC, ++autoGenareteAcNumber,750,false,true)));
	  accountTransfer.put(autoGenareteAcNumber, "aji@gmail.com");
	  users.put("kumar@gmail.com", (new User("Kumar", "kumar@gmail.com", "9086712543", "Male", "kumar@143",(byte) 23, 11000,IFSC, ++autoGenareteAcNumber,750,false,true)));
	  accountTransfer.put(autoGenareteAcNumber, "kumar@gmail.com");
	  users.put("vicky@gmail.com", (new User("Vicky", "vicky@gmail.com", "9803672314", "Male", "vicky@102",(byte) 24, 10000,IFSC, ++autoGenareteAcNumber,750,false,true)));
	  accountTransfer.put(autoGenareteAcNumber, "vicky@gmail.com");
	  users.put("bharath@gmail.com", (new User("Bharath", "bharath@gmail.com", "908645321", "Male", "bharath@007",(byte) 22, 13000,IFSC, ++autoGenareteAcNumber,750,false,true)));
	  accountTransfer.put(autoGenareteAcNumber, "bharat@gmail.com");
  }
	public void start() {
		System.out.println("_________________________________________\n");
		System.out.println("-----------> Greeting ZBank <------------");
		System.out.println("_________________________________________\n");
	
		boolean flag = true;
		while (flag) {
			System.out.println("Choose  option -:) ");
			System.out.println("\t[1].Admin\n\t[2].Apply Personal Loan\n\t[3].Sign Up\n\t[4].Sign In\n\t[5].Quit ");
				switch(Validation.userChoice()) {
				case 1:
					new Admin().bankAdmin();break;
				case 2:try {
						new LoanProcess().loanProcess();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}break;
				case 3:
					addUser();break;
				case 4:
					new UserOperation();break;
				case 5:
					System.out.println("!!! Thank for visiting !!!");
					flag=false;break;
			  default:
				  System.err.println("Invalid input Try again !!!");
				  System.out.println("_________________________________________\n");
				  break;
				}
		}
	}
	

	public void addUser() {
		System.out.println("_________________________________________\n");
		System.out.println("          Create new Account !!!");
		System.out.println("_________________________________________\n");
	    System.err.print(" * ");
	    System.out.println(" Must fill this fields ");
		String name =Validation.isValidName();
			
		String gender = Validation.isValidGender();
		
		byte age = Validation.isValidAge();
		
		String email = Validation.isValidEmail();
		
		String passWord = Validation.isValidPassword();
		
		String phone =Validation.isValidPhoneNumber();
		
		double depositeAmount =Validation.isValidMoney();
		
		users.put(email, (new User(name, email, phone, gender, passWord, age, depositeAmount,IFSC , ++autoGenareteAcNumber,750,false,true)));
		MoneyOperation.recordHistory(email, "Account open", depositeAmount);
		accountTransfer.put(autoGenareteAcNumber, email);
		System.out.println("_________________________________________\n");
		System.out.println("!!!  Account opened successfully !!!!\n");
		System.out.println("          Back to main page                ");
		System.out.println("_________________________________________\n");

	}
	
	
	
	
	
}
