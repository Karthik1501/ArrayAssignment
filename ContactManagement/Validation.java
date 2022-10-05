package contactmanagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	static Scanner sc = new Scanner(System.in);
	    
	public static String isValidEmail() {
		boolean flag = true;
		sc.nextLine();
		while (flag) {
			System.out.print("Enter email :");
			String email = sc.nextLine();
			String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(email);
			if (m.matches())
				return email;
			else
				System.err.println("Inavlid email try again !!! ");
		}
		return "";
	}

	

	public static String isValidPhoneNumber() {
		boolean flag = true;
		while (flag) {
			System.out.print("Enter your phone number:");
			String phone1 = sc.nextLine();
			String regex = "^[0-9]{10}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone1);
			if (m.matches())
				return phone1;
			else
				System.err.println("Invalid Phone Number ");
		}
		return "";
	}

	

	public static String isValidName() {
		boolean flag = true;
		sc.nextLine();
		while (flag) {
			System.out.print("Enter your name :");
			String name = sc.nextLine();
			String regex = "^[a-zA-Z]{4,}";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			if (m.matches())
				return name;
			else
				System.err.println("Invalid name should be at least 4 -15 character :");
		}
		return "";
	}
	
	public static String isValidLable() {
		boolean flag = true;
		while (flag) {
			System.out.print("Enter lable name :");
			String name = sc.next();
			String regex = "^[a-zA-Z]{4,}";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			if (m.matches())
				return name;
			else
				System.err.println("Invalid name should be at least 4 -15 character :");
		}
		return "";
	}

	
	
	
public static  byte userChoice() {
		
		try {
			byte b = sc.nextByte();
			return b;
		}catch(Exception e) {
			//System.out.println("Invalid input contains only 1 - 4");
			sc.nextLine();
		}
		return 0;
	}
	
}
