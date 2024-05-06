package lab6b;

import java.util.Comparator;

/**
* <b>Title:</b> Lab 6b:<br>

* <b>Filename:</b> Team.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 18, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a Team, an object representing a Football team containing parameters
* a Football Team would have, such as a name, wins, and losses.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li
*/

public class Team implements Comparable<Team>{
	private String name;
	private int wins;
	//private int loses;
	//private int draws;
	private int goalsFor;
	private int goalsAgainst;
	//private int points;
	
	private int homeWins;
	private int awayWins;
	private int homeDraws;
	private int awayDraws;
	private int homeLoses;
	private int awayLoses;
	
	public Team(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param homeGame True if home game, false otherwise
	 * @param gf Number of goals scored
	 * @param ga Number of goals for opposing team
	 */
	public void score(boolean homeGame, int gf, int ga) {
		goalsFor += gf;
		goalsAgainst += ga;
		
		if (homeGame) {
			if (gf > ga)
				homeWins++; 
			else if (ga > gf)
				homeLoses++;
			else 
				homeDraws++;
		}
		else {
			if (gf > ga)
				awayWins++; 
			else if (ga > gf)
				awayLoses++;
			else 
				awayDraws++;
		}
	}
	public String getName() {
		return name;
	}
	public int getWins() {
		return homeWins + awayWins;
	}
	public int getLoses() {
		return homeLoses + awayLoses;
	}
	public int getDraws() {
		return homeDraws + awayDraws;
	}
	public int getPoints() {
		return (getWins() * 3) + (getDraws());
	}

	public int getGoalsFor() {
		return goalsFor;
	}
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	public int goalDifference() {
		return goalsFor - goalsAgainst;
	}
	public int getHomeWins() {
		return homeWins;
	}
	public int getHomeDraws() {
		return homeDraws;
	}
	public int getHomeLoses() {
		return homeLoses;
	}
	public int getHomePoints() {
		return homeWins * 3 + homeDraws;
	}
	public int getAwayWins() {
		return awayWins;
	}
	public int getAwayDraws() {
		return awayDraws;
	}
	public int getAwayLoses() {
		return awayLoses;
	}
	public int getAwayPoints() {
		return awayWins * 3 + awayDraws;
	}
	
	public int getGamesPlayed() {
		return homeWins + homeLoses + homeDraws + awayWins + awayLoses + awayDraws;
	}
	public String toString() {
		return String.format("Team %s played %d games, winning %d, losing %d, and drawing %d",
				name, getGamesPlayed(), getWins(), getLoses(), getDraws());
	}
	public boolean equals(Object ot) {
		Team temp = (Team) ot;
		if(temp.getName().equals(this.getName()))
			return true;
		else
			return false;
	}
	public boolean equals(Team ot) {
		if(ot.getName().equals(this.getName()))
			return true;
		else
			return false;
	}
	@Override
	public int compareTo(Team ot) {
		if (this.getWins() > ot.getWins())
			return 1;
		else if (this.getWins() == ot.getWins())
			return 0;
		else
			return -1;
	}
}
// complete this based on information in PDF file
class PointsComparator implements java.util.Comparator<Team> {
	public int compare(Team thisTeam, Team otherTeam) {
		if(thisTeam.getPoints() == otherTeam.getPoints())
			return thisTeam.goalDifference() - otherTeam.goalDifference();
		return thisTeam.getPoints() - otherTeam.getPoints();
	}
}
class HomeWinsComparator implements Comparator<Team> {
	public int compare(Team thisTeam, Team otherTeam) {
		if(thisTeam.getHomeWins() == otherTeam.getHomeWins())
			return thisTeam.getPoints() - otherTeam.getPoints();
		return thisTeam.getHomeWins() - otherTeam.getHomeWins();
	}
}
class AwayWinsComparator implements Comparator<Team> {
	public int compare(Team thisTeam, Team otherTeam) {
		if(thisTeam.getAwayWins() == otherTeam.getAwayWins())
			return thisTeam.getPoints() - otherTeam.getPoints();
		return thisTeam.getAwayWins() - otherTeam.getAwayWins();
	}
}
class NamesComparator implements Comparator<Team> {
	public int compare(Team thisTeam, Team otherTeam) {
		return thisTeam.getName().compareTo(otherTeam.getName());
	}
}