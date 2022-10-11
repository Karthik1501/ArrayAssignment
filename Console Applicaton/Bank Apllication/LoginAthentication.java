package bankapplication;

import java.util.HashMap;
import java.util.Scanner;

public class LoginAthentication {
	static Scanner sc = new Scanner(System.in);
	private final static String adminUser = "Admin";
	private final static String adminPassword = "Admin@010";

	public static String isUser() {
				
            	byte block = 3;
            	while(true ) {
		            	System.out.println("Enter your userEmail");
						String user = sc.nextLine();
						if (BankManagement.users.containsKey(user)) {
							User temp = BankManagement.users.get(user);
									while(true) {
									System.out.println("Enter your password : ");
									String userPassword = sc.nextLine();
									if (temp.getPassWord().equals(userPassword)) {
										System.out.println("\n---------> Login Successfully <---------\n");
										return user;
									} else
										System.err.println("Incorrect Password try again \n");					
								 }
							
						} else
							System.err.println("Invalid username try again \n");
            	}
	    }
	

			public String isAdmin() {
				
				while(true) {
				    System.out.println("Enter your Admin(userName):");
						String admin = sc.nextLine();
						if (admin.equals(adminUser)) {
							while(true) {
							System.out.println("Enter your password : ");
							String userPassword = sc.nextLine();
							if (userPassword.equals(adminPassword)) {
								System.out.println("\n---------> Login Successfully <---------\n");
								return admin;
							} else
								System.out.println("Incorrect Password try again \n");
							
							}
							
						} else
							System.out.println("Invalid username try again times \n");
						
				}
				
			}
}
