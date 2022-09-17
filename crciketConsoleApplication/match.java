package colsoleApp;

import java.util.*;

public class match {

	Team team1, team2, bowlingTeam, battingTeam;

	public match(String team1Name, String[] team1playerNames, String team2Name, String[] Team2PlayerNames) {
		this.team1 = new Team(team1Name);
		team1.addPlayers(team1playerNames);
		this.team2 = new Team(team2Name);
		team2.addPlayers(Team2PlayerNames);
	}

	public Team[] game() {

		// return a result
		Team[] result = new Team[2];
		// user input scanner class
		Scanner input = new Scanner(System.in);
		System.out.println("Who will Toss the coin (0)-Head or (1)-Tails");
		int toss = input.nextInt();

		// random toss genaretor
		Random random = new Random();
		int finalToss = random.nextInt(2);

		System.out.println("------------------------------------------------------------------");

		if (finalToss == toss) {
			System.out.println("!!! India won toss and choose to bat first !!!");
			battingTeam = team1;
			bowlingTeam = team2;
		} else {
			System.out.println("!!! Pakistan won toss and choose to bat first !!!");
			battingTeam = team2;
			bowlingTeam = team1;
		}
		System.out.println("Batting - " + battingTeam.getName());
		System.out.println("Bowling - " + bowlingTeam.getName());
		System.out.println("------------------------------------------------------------------");

		// over fix
		int fixOver = 0;

		// Match start loop
		while (true) {
			// match over fixing
			System.out.println("Choose over 2 or 5");
			int over = input.nextInt();
			// over check
			if (over == 5 || over == 2) {
				fixOver = over;
				break;
			}
		}

		System.out.println("------------------------------------------------------------------");
		// nextBowler, nextBatsman
		int nextBatsman = 2, nextBowler = 10;

		// innings 1st and 2nd batting
		for (int i = 0; i < 2; i++) {

			// over count and overTrace
			int overCount = 0, overTrace = 0;
			;

			// choose batting team openers
			System.out.println(battingTeam.getName() + " Openers !!!");
			Player striker = battingTeam.getPlayerList().get(0);
			System.out.println("Striker - " + striker.name);
			Player nonStriker = battingTeam.getPlayerList().get(1);
			System.out.println("Non~Striker - " + nonStriker.name);

			// choose bowlwer
			Player bowler = bowlingTeam.getPlayerList().get(10);
			System.out.println("bowler - " + bowler.name);

			System.out.println("------------------------------------------------------------------");

			// ball count
			int ballCount = 0;

			while (true) {
				ballCount++;// ballcount
				System.out.println("Enter run (0 to 6) ,(o)-out ,(w)-wide ,(n)-noball  ");
				char checkBall = input.next().charAt(0);

				// check batsman out change the batsman
				if (checkBall == 'o') {

					// setWickets
					bowler.setWickets();
					striker.setBalls();
					System.out.println(
							striker.name + " " + striker.getRuns() + "(" + striker.getBalls() + ")" + " - out ");
					bowlingTeam.setWickets(bowler);

					// only 10 batsman allow to batting
					if (nextBatsman < 11) {
						striker = battingTeam.getPlayerList().get(nextBatsman++);
						System.out.println("Next batsman -" + striker.name);
					} else {
						System.out.println(battingTeam.getName() + " All out");
						break;
					}

				}

				// check ball wide or noball
				else if (checkBall == 'w' || checkBall == 'n') {
					// System.out.println("wide or noball");
					battingTeam.setTeamScore(1);
					ballCount--;
				}

				else {
					// check input outOfrange
					if (checkBall - 48 <= 6) {

						if (checkBall % 2 == 0) {
							System.out.println("even run");
							battingTeam.setScore(striker, checkBall - 48);
							striker.setBalls();// striker ballsCount

							if (checkBall - 48 == 4) {
								System.out.println("Nice Shot!!!\nOne Bounce Over the Rope");
								striker.setFour();
							} else if (checkBall - 48 == 6) {
								striker.setSix();
								System.out.println("There is biggieeeee !!!\nit's " + striker.name + " Special !!!");
							}

						} else {
							// System.out.println("odd run swap batsman");
							battingTeam.setScore(striker, checkBall - 48);
							striker.setBalls();
							// chnage Player
							Player temPlayer = striker;
							striker = nonStriker;
							nonStriker = temPlayer;
							if (ballCount % 6 != 0)
								System.out.println("Striker - " + striker.name + "\nNon-Striker - " + nonStriker.name);
						}

					} else {
						System.out.println("Run outOfrange (0 - 6)");
						ballCount--;
					}

				}

				// overTrace
				if (ballCount % 6 == 0) {
					overTrace++;
					System.out.println("------------------------------------------------------------------");
					System.out.println(overTrace + " ~ over");
					// change bowler
					if (fixOver != overTrace) {
						bowler = bowlingTeam.getPlayerList().get(nextBowler--);
						System.out.println("Next bowler - " + bowler.name);
						// after change over swap batsman
						Player temPlayer = striker;
						striker = nonStriker;
						nonStriker = temPlayer;
						System.out.println("Striker - " + striker.name + "\nNon-Striker - " + nonStriker.name);
					}

				}

				// over count to bowler
				if (ballCount % 6 == 0) {
					bowler.setOver();
				}
				// check team or not
				if (i == 1)
					if (battingTeam.getScore() > bowlingTeam.getScore()) {
						result[0] = battingTeam;
						result[1] = bowlingTeam;
						break;
					}

				// check over is end
				if (ballCount == fixOver * 6) {
					result[0] = bowlingTeam;
					result[1] = battingTeam;
					break;
				}

			} // while loop end

			// 2nd innings start
			if (i == 0) {
				System.out.println("------------------------------------------------------------------");
				System.out.println(bowlingTeam.getName() + "  target is :" + (battingTeam.getScore() + 1));
				System.out.println("2nd innings start ");
				// swap teams
				Team tempTeam = battingTeam;
				battingTeam = bowlingTeam;
				bowlingTeam = tempTeam;

			}

		} // for loop end

		// return result
		return result;
	}

}
