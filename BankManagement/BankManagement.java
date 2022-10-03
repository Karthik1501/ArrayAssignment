package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class BankManagement {
  static Scanner sc = new Scanner(System.in);
  final static String IFSC = "ZBANK007";
  static long autoGenareteAcNumber = 100001010;
  
  HashMap<String, User> users = new HashMap<>();
  HashMap<Long, String> acTransfer = new HashMap<>();
  
  BankManagement(){
	  users.put("aji@gmail.com", (new User("Aji", "aji@gmail.com", "9087654321", "Male", "aji@123",(byte) 25, 12000,IFSC, ++autoGenareteAcNumber)));
	  acTransfer.put(autoGenareteAcNumber, "aji@gmail.com");
	  users.put("kumar@gmail.com", (new User("Kumar", "kumar@gmail.com", "9086712543", "Male", "kumar@143",(byte) 23, 11000,IFSC, ++autoGenareteAcNumber)));
	  acTransfer.put(autoGenareteAcNumber, "kumar@gmail.com");
	  users.put("vicky@gmail.com", (new User("Vicky", "vicky@gmail.com", "9803672314", "Male", "vicky@102",(byte) 24, 10000,IFSC, ++autoGenareteAcNumber)));
	  acTransfer.put(autoGenareteAcNumber, "vicky@gmail.com");
	  users.put("bharath@gmail.com", (new User("Bharath", "bharath@gmail.com", "908645321", "Male", "bharath@007",(byte) 22, 13000,IFSC, ++autoGenareteAcNumber)));
	  acTransfer.put(autoGenareteAcNumber, "bharat@gmail.com");
  }
	public void start() {
		System.out.println("_________________________________________\n");
		System.out.println("-----------> Greeting ZBank <------------");
		System.out.println("_________________________________________\n");
	
		boolean flag = true;
		while (flag) {
			System.out.println("Choose before option -:) ");
			System.out.println("_________________________________________\n");
			System.out.println("1.Admin\n2.New user\n3.Existing user\n4.Quit ");
				switch(Validation.userChoice()) {
				case 1:
					BankAdmin();break;
				case 2:
					addUser();break;
				case 3:
					new UserOperation(users, acTransfer);break;
				case 4:
					System.out.println("!!! Thank for visiting !!!");
					flag=false;
			  default:
				  System.err.println("Try again !!!");
				  System.out.println("_________________________________________\n");
				  break;
				}
		}
	}
	

	public void addUser() {
		System.out.println("_________________________________________\n");
		System.out.println("Create new Account !!!");
		System.out.println("_________________________________________\n");
	
		String name =Validation.isValidName();
			
		String gender = Validation.isValidGender();
		
		byte age = Validation.isValidAge();
		
		String email = Validation.isValidEmail();
		
		String passWord = Validation.isValidPassword();
		
		String phone =Validation.isValidPhoneNumber();
		
		double depositeAmount =Validation.isValidMoney();
		
		users.put(email, (new User(name, email, phone, gender, passWord, age, depositeAmount,IFSC , autoGenareteAcNumber++)));
		MoneyOperation.recordHistory(email, "Account open", depositeAmount);
		acTransfer.put(autoGenareteAcNumber, email);
		System.out.println("_________________________________________\n");
		System.out.println("!!!  Account opened successfully !!!!\n");
		System.out.println("          Back to main page                ");
		System.out.println("_________________________________________\n");

	}
	
	
	
	private void BankAdmin() {
		
		LoginAthentication  adminAuth = new LoginAthentication();
		String auth= adminAuth.isAdmin();
		while(!auth.isEmpty()) {
		if(auth.length()!=0) {
			System.out.println("_________________________________________\n");
			System.out.println("-------> Welcome Admin Dashboard <--------");
			System.out.println("_________________________________________\n");
			System.out.println("1.View customer details\n2.Back");
			byte b =Validation.userChoice();
			if(b==1) {
				System.out.println("_________________________________________\n");
				System.err.println("Total Account in this branch :"+"\t\t"+users.size());
				System.out.println("_________________________________________\n");
				for(Entry<String, User> temp:users.entrySet()) {
					System.out.println(temp.getKey());
					System.out.println( temp.getValue());
				}
		   }
			else if(b == 2)
				 break;
			else
				System.err.println("Invalid input try again !!!");
	        }
		
	    }
		
	}
	
	
}
