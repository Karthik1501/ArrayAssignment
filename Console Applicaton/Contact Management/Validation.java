package contactmanagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	static Scanner sc = new Scanner(System.in);
	    
	public static String isValidEmail() {
		sc.nextLine();
		while (true) {
			System.out.print("Enter email :");
			String email = sc.nextLine();
			String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches())
				return email;
			else
				System.err.println("Inavlid email try again !!! ");
		}
	}

	

	public static String isValidPhoneNumber() {
		
		sc.nextLine();
		while (true) {
			System.out.print("Enter your phone number:");
			String phone1 = sc.nextLine();
			String regex = "^[0-9]{10}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher =  pattern.matcher(phone1);
			if (matcher.matches())
				return phone1;
			else
				System.err.println("Invalid Phone Number ");
		}
	}
		

	

	public static String isValidName() {
		boolean flag = true;
		sc.nextLine();
		while (flag) {
			System.out.print("Enter your name :");
			String name = sc.nextLine();
			String regex = "^[a-zA-Z]{4,}";
			Pattern  pattern = Pattern.compile(regex);
			Matcher matcher =  pattern.matcher(name);
			if (matcher.matches())
				return name;
			else
				System.err.println("Invalid name should be at least 4 -15 character :");
		}
		return "";
	}
	
	public static String isValidLable() {
		
		while (true) {
			System.out.print("Enter lable name :");
			String name = sc.next();
			String regex = "^[a-zA-Z]{4,}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches())
				return name;
			else
				System.err.println("Invalid name should be at least 4 -15 character :");
		}
	}

	
	
	
public static  byte userChoice() {
		
		try {
			byte getChoice = sc.nextByte();
			return getChoice;
		}catch(Exception e) {
			//System.out.println("Invalid input contains only 1 - 4");
			sc.nextLine();
		}
		return 0;
	}
	
}
