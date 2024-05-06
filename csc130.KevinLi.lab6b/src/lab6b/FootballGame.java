package lab6b;

import java.time.LocalDate;

/**
* <b>Title:</b> Lab 6b:<br>

* <b>Filename:</b> FootballApp.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 18, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a FootballGame, an object representing a Football game containing parameters
* a Football Game would have, such as a homeTeam, an awayTeam, homeGoals, awayGoals, etc.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li
*/

public class FootballGame implements Comparable<FootballGame>{
	// Div,Date,Time,HomeTeam,AwayTeam,FTHG,FTAG,FTR,HTHG,HTAG,HTR,Referee,HS,AS
	private String div; // League Division
	private LocalDate date; // Match Date (dd/mm/yy)
	private String time; // Time of match kick off
	private String homeTeam; // Home Team
	private String awayTeam; // Away Team
	private int homeGoals; // FTHG and HG; //Full Time Home Team Goals
	private int awayGoals; // FTAG and AG; //Full Time Away Team Goals
	private char winner; // FTR and Res; //Full Time Result (H=Home Win, D=Draw, A=Away Win)
	private int homeHalfTimeGoals; // HTHG; //Half Time Home Team Goals
	private int awayHalfTimeGoals; // HTAG; //Half Time Away Team Goals
	private char halfTimeWinner; // HTR; //Half Time Result (H=Home Win, D=Draw, A=Away Win)
	private String referee; // Match Referee
	
	
	// Match Statistics (where available)
	// Attendance; //Crowd Attendance	
	// HS; //Home Team Shots
	// AS; //Away Team Shots
	// HST; //Home Team Shots on Target
	// AST; //Away Team Shots on Target
	// HHW; //Home Team Hit Woodwork
	// AHW; //Away Team Hit Woodwork
	// HC; //Home Team Corners
	// AC; //Away Team Corners
	// HF; //Home Team Fouls Committed
	// AF; //Away Team Fouls Committed
	// HFKC; //Home Team Free Kicks Conceded
	// AFKC; //Away Team Free Kicks Conceded
	// HO; //Home Team Offsides
	// AO; //Away Team Offsides
	// HY; //Home Team Yellow Cards
	// AY; //Away Team Yellow Cards
	// HR; //Home Team Red Cards
	// AR; //Away Team Red Cards

	public FootballGame(String div, LocalDate date, String time, String homeTeam, String awayTeam, int homeGoals,
			int awayGoals, char winner, int homeHalfTimeGoals, int awayHalfTimeGoals, char halfTimeWinner,
			String referee) {
		super();
		this.div = div;
		this.date = date;
		this.time = time;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
		this.winner = winner;
		this.homeHalfTimeGoals = homeHalfTimeGoals;
		this.awayHalfTimeGoals = awayHalfTimeGoals;
		this.halfTimeWinner = halfTimeWinner;
		this.referee = referee;
	}

	// accessors and mutators
	
	public String getDiv() {
		return div;
	}
	public String getDate() {
		return date.toString();
	}
	public void setDiv(String div) {
		this.div = div;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

	public char getWinner() {
		return winner;
	}

	public void setWinner(char winner) {
		this.winner = winner;
	}

	public int getHomeHalfTimeGoals() {
		return homeHalfTimeGoals;
	}

	public void setHomeHalfTimeGoals(int homeHalfTimeGoals) {
		this.homeHalfTimeGoals = homeHalfTimeGoals;
	}

	public int getAwayHalfTimeGoals() {
		return awayHalfTimeGoals;
	}

	public void setAwayHalfTimeGoals(int awayHalfTimeGoals) {
		this.awayHalfTimeGoals = awayHalfTimeGoals;
	}

	public char getHalfTimeWinner() {
		return halfTimeWinner;
	}

	public void setHalfTimeWinner(char halfTimeWinner) {
		this.halfTimeWinner = halfTimeWinner;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FootballGame [div=" + div + ", date=" + date + ", time=" + time + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + ", homeGoals=" + homeGoals + ", awayGoals=" + awayGoals + ", winner="
				+ winner + ", homeHalfTimeGoals=" + homeHalfTimeGoals + ", awayHalfTimeGoals=" + awayHalfTimeGoals
				+ ", halfTimeWinner=" + halfTimeWinner + ", referee=" + referee + "]";
	}
	// add compareTo method so the class will not be abstract
	// compare by date and if dates are equal compare by time.
	
	public int compareTo(FootballGame other) {
		if (this.date.isAfter(other.date))
			return 1;
		else if (this.date.isBefore(other.date))
			return -1;
		else {
			if (Integer.parseInt(this.time) > Integer.parseInt(other.time))
				return 1;
			else if (Integer.parseInt(this.time) < Integer.parseInt(other.time))
				return -1;
			else 
				return 0;
		}
	}
}
