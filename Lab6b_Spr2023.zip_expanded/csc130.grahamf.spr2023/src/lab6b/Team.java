package lab6b;

import java.util.Comparator;

public class Team implements Comparable<Team>{
	private String name;
	//private int wins;
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

	/**
	 * 
	 * @param homeGame True if home game, false otherwise
	 * @param gf Number of goals scored
	 * @param ga Number of goals for opposing team
	 */
	public void score(boolean homeGame, int gf, int ga) {

	}
	public String getName() {
		return name;
	}
	public int getWins() {
		return 0;
	}
	public int getLoses() {
		return 0;
	}
	public int getDraws() {
		return 0;
	}
	public int getPoints() {
		return 0;
	}

	public int getGoalsFor() {
		return 0;
	}
	public int getGoalsAgainst() {
		return 0;
	}
	public int goalDifference() {
		return 0;
	}
	public int getHomeWins() {
		return 0;
	}
	public int getHomeDraws() {
		return 0;
	}
	public int getHomeLoses() {
		return 0;
	}
	public int getHomePoints() {
		return 0;
	}
	public int getAwayWins() {
		return 0;
	}
	public int getAwayDraws() {
		return 0;
	}
	public int getAwayLoses() {
		return 0;
	}
	public int getAwayPoints() {
		return 0;
	}
	
	public int getGamesPlayed() {
		return 0;
	}
	public String toString() {
		return null;
	}
	public boolean equals(Object ot) {
		
		return false;
	}
	public boolean equals(Team ot) {
		return false;
	}
	@Override
	public int compareTo(Team ot) {
		return 0;
	}
}
// complete this based on information in PDF file
class PointsComparator implements Comparator<Team> {
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