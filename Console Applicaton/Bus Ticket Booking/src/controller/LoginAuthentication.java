package controller;


import java.util.Scanner;

import model.Passenger;

public class LoginAuthentication extends UserData {
	static Scanner sc = new Scanner(System.in);
    Passenger currentUser ;
	public Passenger isUser() {
            	byte block = 3;
            	while(true && block!=0) {
		            	System.out.println("Enter your user name");
						String user = sc.nextLine();
						if (UserData.users.containsKey(user)) {
									while(true && block != 0) {
									System.out.println("Enter your password : ");
									String userPassword = sc.nextLine();
									 currentUser =UserData.users.get(user);
									if (currentUser.getPassWord().equals(userPassword)) {
										System.out.println("\n---------> Login Successfully <---------\n");
										return currentUser;
									} else
										System.err.println("Incorrect Password try again times "+(--block)+" remaining !!!\n");
									
									
									if(block ==0) {
										System.err.println("Sry your A\\c blocked try after some times");
									    break;
									}	
								 }
							
						} else
							System.err.println("Invalid username try again times "+(--block)+" remaining !!!\n");
						if(block ==0) {
							System.err.println("Sry your A\\c blocked try after some times");
						    break;
						}
            	}
				return currentUser;
				
	    }
	

			
}
