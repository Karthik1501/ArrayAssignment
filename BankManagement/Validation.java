package bankapplication;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	static Scanner sc = new Scanner(System.in);
	    
	public static String isValidEmail() {
		boolean flag = true;
		  sc.nextLine();
		while (flag) {
			System.out.print("Enter email (will be set as default email):");
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

	public static String isValidPassword() {
		boolean flag = true;
		
		while (flag) {
			System.out.println("Enter passsword (will be set as default password):");
			String password = sc.nextLine();
			String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9s])(?=.*[@#$%]).{8,20}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(password);
			if (m.matches())
				return password;
			else
				System.err.println("Password length min 8 char contains(upper,lower,number,special)");
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

	public static String isValidGender() {
		boolean flag = true;
		while (flag) {
			System.out.print("Enter your Gender :");
			String gender = sc.nextLine();
			String regex = "male female others";
			if (regex.contains(gender))
				return gender;
			else
				System.err.println("Invalid Gender try again  :");
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

	public static byte isValidAge() {
		boolean flag = true;
		while (flag) {
			try {
				System.out.print("Enter your age:");
				byte age = sc.nextByte();
				if (age > 18)
					return age;
				else
					System.err.println("Sorry your not eligible BcZ age is below 18 ");
			} catch (Exception e) {
				System.err.println("Input contains only number -:)");
				sc.nextLine();
			}
		}
		return 0;
	}
	
	public static double isValidMoney() {
		boolean flag = true;
		while (flag) {
			try {
				System.out.println("Enter Amount(Minimum Rs.500)");
				double acOpen = sc.nextDouble();
				
				if (acOpen >= 500)
					return acOpen;
				else
					System.err.println("Minimum amount Rs.500/- :");
			}catch(Exception e) {
				System.err.println("Input contains only Number's !!!s)");
				sc.nextLine();
			}
		}
		return 0;
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
