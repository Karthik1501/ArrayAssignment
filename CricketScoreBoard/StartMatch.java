package colsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class StartMatch {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter team1 name :");
        String team1 = sc.next();
        
        String[] team1Players = new String[11];
        
        System.out.println("Enter "+team1+" players name :");
        for(int i=0;i<11;i++) {
        	team1Players[i]=sc.next();
        }
        //sc.next();
        System.out.println("Enter team2 name :");
        String team2 = sc.next();
        
        
         String[] team2Players = new String[11];
         
         System.out.println("\nEnter "+team2+" players name :");
        for(int i=0;i<11;i++) {
        	team2Players[i]=sc.next();
        }
        
//		String[] india = { "Rohit(C)", "Rahul", "Kohli", "Surya", "Hooda", "Pant(Wk)", "Hardik", "Jaddu", "Bhuvi",
//				"Chahal", "Harshadeep" };
//		String[] pakistan = { "Babars(C)", "Rizwan", "Fakhar", "Nawaz", "Kushdil", "Asif", "Ifthikir", "Shadap",
//				"Haris", "Hasnain", "Naseem" };

		Match m = new Match(team1, team1Players, team2, team2Players);
		
		Team[] result = m.game();
		if (result == null)
			System.out.println("draw");
		else {
			System.out.println("------------------------------------------------------------------");
			System.out.println(result[0].getName() + " won !!!!!! ");
			System.out.println("------------------------------------------------------------------");
			
			System.out.printf("%-15s%s\t%s\t%s\t%s\n", "Name", "Run", "Ball", "Four", "Six");
			
			for (Player p : result[0].getPlayerList())
				System.out.printf("%-15s%d\t%d\t\n", p.getName(), p.getRuns() ,p.getBalls() ,p.getFour() ,p.getSix());
			
			
			
			
			System.out.println("------------------------------------------------------------------");

			System.out.println( result[1].getName() + "loose");
			
			System.out.println("------------------------------------------------------------------");
			
			System.out.printf("%-15s%s\t%s\t%s\t%s\n", "Name", "Run", "Ball", "Four", "Six");
			
			for (Player p : result[1].getPlayerList())
				System.out.printf("%-15s%d\t%d\t%d\t%d\n", p.getName(), p.getRuns(), p.getBalls() ,p.getFour() ,p.getSix());
		}



	}
}
/*
Rohit(C)
Rahul
Kohli
Surya
Hooda
Pant(Wk)
Hardik
Jaddu
Bhuvi
Chahal
Harshadeep


Babars(C)
Rizwan
Fakhar
Nawaz
Kushdil
Asif
Ifthikir
Shadap
Haris
Hasnain
Naseem

*/