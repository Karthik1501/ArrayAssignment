package colsoleApp;

import java.util.*;

public class Team {
	ArrayList<Player> playerList;
	private String name;
	private int score;
	private int wickets;

	Team(String name) {
		this.playerList = new ArrayList<>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(Player bowler) {
		bowler.setWickets();
		this.wickets++;
	}

	public void setTeamScore(int score) {

		this.score += score;
	}

	public void setScore(Player batsman, int score) {
		batsman.addRuns(score);
		this.score += score;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void addPlayers(String[] p) {
		for (String playerName : p) {
			Player playerObj = new Player(playerName);
			this.playerList.add(playerObj);
		}

	}
}
