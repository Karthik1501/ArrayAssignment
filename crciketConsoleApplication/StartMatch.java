package colsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class StartMatch {

	public static void main(String[] args) {

		String[] india = { "Rohit(C)", "Rahul", "Kohli", "Surya", "Hooda", "Pant(Wk)", "Hardik", "Jaddu", "Bhuvi",
				"Chahal", "Harshadeep" };
		String[] pakistan = { "Babars(C)", "Rizwan", "Fakhar", "Nawaz", "Kushdil", "Asif", "Ifthikir", "Shadap",
				"Haris", "Hasnain", "Naseem" };

		match m = new match("IND", india, "PAK", pakistan);
		Team[] result = m.game();
		if (result == null)
			System.out.println("draw");
		else {

			System.out
					.println(result[0].getName() + " won by" + (result[0].getScore() - result[1].getScore()) + " runs");
			System.out.println("----------------------------------------------------------");
			
			System.out.printf("%-15s%s\t%s\t%s\t%s\n", "Name", "Run", "Ball", "Four", "Six");
			
			for (Player p : result[0].getPlayerList())
				System.out.printf("%-15s%d\t%d\t%d\t%d\n", p.getName(), p.getRuns(), p.getBalls(), p.getFour(),
						p.getSix());
			
			System.out.println("----------------------------------------------------------");

			System.out.println(
					result[1].getName() + " loose by" + (result[0].getScore() - result[1].getScore()) + " runs");
			
			System.out.println("----------------------------------------------------------");
			
			System.out.printf("%-15s%s\t%s\t%s\t%s\n", "Name", "Run", "Ball", "Four", "Six");
			for (Player p : result[1].getPlayerList())
				System.out.printf("%-15s%d\t%d\t%d\t%d\n", p.getName(), p.getRuns(), p.getBalls(), p.getFour(),
						p.getSix());
		}



	}
}
