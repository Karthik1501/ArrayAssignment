package bankapplication;

import java.util.HashMap;
import java.util.Scanner;

public class LoginAthentication {
	static Scanner sc = new Scanner(System.in);
	private final static String adminUser = "Admin";
	private final static String adminPassword = "Admin@010";

	public String isUser(HashMap<String, User> users) {
				boolean flag =true;
            	byte block = 3;
            	while(flag && block!=0) {
		            	System.out.println("Enter your userEmail");
						String user = sc.nextLine();
						if (users.containsKey(user)) {
							User temp = users.get(user);
									while(flag && block != 0) {
									System.out.println("Enter your password : ");
									String userPassword = sc.nextLine();
									if (temp.getPassWord().equals(userPassword)) {
										System.out.println("\n---------> Login Successfully <---------\n");
										return user;
									} else
										System.err.println("Incorrect Password try again times "+(--block)+" remaining !!!\n");
									
									
									if(block ==0) {
										System.err.println("Sry your A\\c blocked try after some times");
									    flag = false;
									}	
								 }
							
						} else
							System.err.println("Invalid username try again times "+(--block)+" remaining !!!\n");
						if(block ==0) {
							System.err.println("Sry your A\\c blocked try after some times");
						     flag = false;
						}
            	}
				return "";
	    }
	

			public String isAdmin() {
				boolean flag = true;
				byte block =3;
				while(flag && block !=0) {
				    System.out.println("Enter your Admin(userName):");
						String admin = sc.nextLine();
						if (admin.equals(adminUser)) {
							while(flag && block !=0) {
							System.out.println("Enter your password : ");
							String userPassword = sc.nextLine();
							if (userPassword.equals(adminPassword)) {
								System.out.println("\n---------> Login Successfully <---------\n");
								return admin;
							} else
								System.out.println("Incorrect Password try again times "+(--block)+" remaining !!!!\n");
							if(block ==0) {
								System.err.println("Sry your A\\c blocked try after some times");
							   flag = false;
							}
							}
							
						} else
							System.out.println("Invalid username try again times "+(--block)+" remaining !!!!\n");
						if(block ==0) {
							System.err.println("Sry your A\\c blocked try after some times");
						     flag = false;
						}
				}
				return "";

			}
}
