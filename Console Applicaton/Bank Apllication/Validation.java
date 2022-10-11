package bankapplication;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	static Scanner sc = new Scanner(System.in);
	   
	public static String isValidEmail() {
		 sc.nextLine();
		while (true) {
			System.out.print("Enter email (will be set as default email) * : ");
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

	public static String isValidPassword() {
	
		while (true) {
			System.out.println("Enter passsword (will be set as default password) * :");
			String password = sc.nextLine();
			String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9s])(?=.*[@#$%]).{8,20}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(password);
			if (matcher.matches())
				return password;
			else
				System.err.println("Password length min 8 char contains(upper,lower,number,special)");
		}
	}

	public static String isValidPhoneNumber() {
		while (true) {
			System.out.print("Enter your phone number * :");
			
			String phone1 = sc.nextLine();
			String regex = "^[6-9][0-9]{9}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone1);
			if (m.matches())
				return phone1;
			else
				System.err.println("Invalid Phone Number ");
		}
	}

	public static String isValidGender() {
		while (true) {
			System.out.print("choose option * -:)\n\t(1).Male\n\t(2).Female\n\t(3).Others");
			switch(userChoice()) {
			case 1: return "male";
			case 2: return "female";
			case 3: return "Others";
			default:
				System.err.println("Invalid Gender try again  :");
			}
		}

	}

	public static String isValidName() {
		sc.nextLine();
		while (true) {
			System.out.print("Enter your name * :");
			String name = sc.nextLine();
			String regex = "^[a-zA-Z]{4,}";
			Pattern pattern = Pattern.compile(regex);
			Matcher m = pattern.matcher(name);
			if (m.matches())
				return name;
			else
				System.err.println("Invalid name should be at least 4 -15 character :");
		}

	}

	public static byte isValidAge() {
	
		while (true) {
			try {
				System.out.print("Enter your age *:");
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
	
	}
	
	public static double isValidMoney() {
		
		while (true) {
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
	
	}
	
public static  byte userChoice() {
		
		try {
			byte getChoice = sc.nextByte();
			return getChoice;
		}catch(Exception e) {
			
			sc.nextLine();
		}
		return 0;
	}
	
}
