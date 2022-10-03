package colsoleApp;

import java.util.*;

public class Match {

	Team team1, team2, bowlingTeam, battingTeam;

	public Match(String team1Name, String[] team1playerNames, String team2Name, String[] Team2PlayerNames) {
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
			System.out.println("!!!"+team1.getName()+" won toss and choose to bat first !!!");
			battingTeam = team1;
			bowlingTeam = team2;
		} else {
			System.out.println("!!! "+team2.getName()+" won toss and choose to bat first !!!");
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
			

			// choose batting team openers
			System.out.println(battingTeam.getName() + " Openers !!!");
			
			Player striker = battingTeam.getPlayerList().get(0);
			System.out.println("Striker - " + striker.getName());
			
			Player nonStriker = battingTeam.getPlayerList().get(1);
			System.out.println("Non~Striker - " + nonStriker.getName());

			// choose bowler
			Player bowler = bowlingTeam.getPlayerList().get(10);
			System.out.println("bowler - " + bowler.getName());

			System.out.println("------------------------------------------------------------------");

			// ball count
			int ballCount = 0;

			while (true) {
				System.out.println("____________________________________________________________________\n");
		        System.out.println("\t Batting - "+battingTeam.getName()+"\t"+battingTeam.getScore()+"/"+bowlingTeam.getWickets()+"\t"+striker.getName()+" - "+striker.getRuns()+"("+striker.getBalls()+")"+"*    "+nonStriker.getName()+" - "+nonStriker.getRuns()+"("+nonStriker.getBalls()+")");
		    	System.out.println("\t Over  - "+"("+overTrace+"."+ballCount % 6+")"+" \t\t CurrentBowler - "+bowler.getName()+"");
		        System.out.println("____________________________________________________________________\n");
		        System.out.println("Enter run (0 to 6)");
				char checkBall = input.next().charAt(0);
				ballCount++;// ballcount
				// check batsman out change the batsman
				if (checkBall == 'o') {

					// setWickets
					//bowler.setWickets();
					striker.setBalls();
					bowlingTeam.setWickets(bowler);
                    //battingTeam.setWickets(striker);
					System.out.println(
					striker.getName() + " " + striker.getRuns() + "(" + striker.getBalls() + ")" + " - out ");
					
					// only 10 batsman allow to batting
					if (nextBatsman < 11) {
						striker = battingTeam.getPlayerList().get(nextBatsman++);
						System.out.println("Next batsman -" + striker.getName());
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
							// System.out.println("even run");
							battingTeam.setScore(striker, checkBall - 48);
							striker.setBalls();// striker ballsCount

							if (checkBall - 48 == 4) {
								System.out.println("Nice Shot!!");
								striker.setFour();
							} else if (checkBall - 48 == 6) {
								striker.setSix();
								System.out.println("it's " + striker.getName() + " Special !!!");
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
								System.out.println("Striker - " + striker.getName() + "\nNon-Striker - " + nonStriker.getName());
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
						bowler = bowlingTeam.getPlayerList().get(--nextBowler);
						System.out.println("Next bowler - " + bowler.getName());
						// after change over swap batsman
						Player temPlayer = striker;
						striker = nonStriker;
						nonStriker = temPlayer;
						System.out.println("Striker - " + striker.getName() + "\nNon-Striker - " + nonStriker.getName());
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
				System.out.println("_____________________________________________________________________\n");
				System.out.println(bowlingTeam.getName() + "  target is :" + (battingTeam.getScore() + 1));
				System.out.println("_____________________________________________________________________\n");
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
