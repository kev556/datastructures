package lab6b;

import java.time.LocalDate;

public abstract class FootballGame implements Comparable<FootballGame>{
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

	@Override
	public String toString() {
		return "FootballGame [div=" + div + ", date=" + date + ", time=" + time + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + ", homeGoals=" + homeGoals + ", awayGoals=" + awayGoals + ", winner="
				+ winner + ", homeHalfTimeGoals=" + homeHalfTimeGoals + ", awayHalfTimeGoals=" + awayHalfTimeGoals
				+ ", halfTimeWinner=" + halfTimeWinner + ", referee=" + referee + "]";
	}
	// add compareTo method so the class will not be abstract
	// compare by date and if dates are equal compare by time.
}
