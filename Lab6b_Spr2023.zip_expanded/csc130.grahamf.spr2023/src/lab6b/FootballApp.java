package lab6b;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;


public class FootballApp{
	public static void main(String[] args) {

		// 1. create a File object that references the file E0.csv
		// call the exists method for the file, if it returns false, call the createFile method
		
		// 2. create an instantiate an OrderedArrayList<Team> object and pass a new NamesComparator object its argument
		// this will store a list of teams - there are 20 teams
		
		
		// 3. create an instantiate an ArrayList<FootballGame>  object and use the default constructor
		// this will store a list of games played
		
		
		
		// 4. create a variable for the Scanner class
		Scanner scan = null;
		
		// 5. fields necessary to instantiate a Football object
		String div;
		LocalDate date;
		String time;
		String homeTeam;
		String awayTeam;
		int homeGoals;
		int awayGoals;
		char winner;
		int homeHalfTimeGoals;
		int awayHalfTimeGoals;
		char halfTimeWinner;
		String referee;

		// 6. create a try/catch block to read data from the text file and populate the lists
		try {
			// 7. connect the Scanner to the file created in step 1
			
			// 8. read a line from the file

			
			// 9. set the delimiter for the scanner to a comma - the default is a whitespace, but the data is separated by commas
			scan.useDelimiter(",");
			
			// 10. while there is more data to be read from the file - hasNextLine
			while (true) {
				/* example data
				  E0,05/08/2022,20:00,Crystal Palace,Arsenal,0,2,A,0,1,A,A Taylor
				*/
				// 11. read the division
				
				
				// 12. read and split the date based on / then create a LocalDate object
				String[] tmpDate = scan.next().split("/");
				date = LocalDate.parse(tmpDate[2] + "-" + tmpDate[1] + "-" + tmpDate[0]);
				
				// 13. read the tile (String)
				
				// 14. read the homeTeam (String)
				
				// 15. read the awayTeam (String)
				
				// 16. read the homeGoals (int)
				
				// 17. read the awayGoals (int)
				
				// 18. read the winner of the game (char)
				
				// 19. read the homeHalfTimeGoals (int)
				
				// 20. read the awayHalfTimeGoals (int)
				
				// 21. read the halftimeWinner
				
				// 22. read the referee
				
				
				// 23. ignore the rest of the data on the line 
				
				// 24. construct a FootballGame object by passing the data read in the order specifies by the constructor
				FootballGame game = new FootballGame(div, date, time, homeTeam, awayTeam, homeGoals, awayGoals, winner,
						homeHalfTimeGoals, awayHalfTimeGoals, halfTimeWinner, referee);
				
				// 25. create Team object for the away team based on the name of the away team read
				
				// 26. create Team object for the home team based on the name of the home team read
				
				
				// 27. check the teamList to see if contains the home team created in step 26 above
				// if it does not - it must mean the team is not in the team list yet
				// call the score method for the team and pass true, home goals, and away goals
				// add the home team to the list
				if(true) {
				// 28. otherwise the team is already in the list
				// find and get the team in the list and store it in the home team variable created above
				// then call the score method for the team and pass true, home goals, and away goals
				}else {
					
					
				}
				//39. do the same as above, but for the away team
				// check the teamList to see if contains the away team (see 27)
				// call the score method with false, away goals, and home goals
				if() {
					
				}
				// 40. see comment 28 and 39
				else {
					
					
				}
				// 41. add the game created in step 24 to the games list created in step 3
				
			} //end while loop
			
			
			// 42. display the list of teams declared in step 2
			
			
			// displays the title
			System.out.println("\nPremier League Games Played:");
			// 43. call the gamesPlayed and pass the games created in step 3
			
			// displays the title
			System.out.println("\nLeague Table:");
			// 44. call the sort method on the list of teams and pass it a new PointsComparator
			// this will sort the data by points
			// store the result in an ArrayList<Team>
			
			// 45. call the results method and pass the list from step above
			
			// displays the title
			System.out.println("\nTeams by Home Wins:");
			// 46. call the results method and pass the list of teams (step 44) and the string "home"
			// this should sort the teams by home wins
			
			
			// displays the title
			System.out.println("\nTeams by Away Wins:");
			// 47. call the results method and pass the list of teams (step 44) and the string "home"
			// this should sort the teams by away wins
			
			
			// the following permits the user to display information for a team she/he selects
			// then repeats until they enter q to quit
			scan = new Scanner(System.in);
			char flag = 'n';
			while(flag != 'q' && flag != 'Q') {
				//48.  call the teamGames method and passes the list of teams and the Scanner
				
				System.out.print("Enter Q to quit or any other character ro repeat: ");
				try {
				flag = scan.nextLine().trim().charAt(0);
				}catch(RuntimeException re) {
					
				}
			}
		} catch (IOException e) {
			System.err.println("Error accessing file");
		} finally {
			scan.close();
		}
	}
	/**
	 * Displays list of games played by a specific team
	 * @param games List of games played to date
	 * @param teamName Name of the team
	 */
	public static void teamGames(ArrayList<FootballGame> games, Team team) {
		// 1. Instantiate an ArrayList<FootballGame> and store its address in a variable
		
		// 2. create a loop to get each game and add it to the list created above
		// if the name of the team matches a home or away team in the game
		
		System.out.println();
		System.out.println(String.format("Games played by %s:", team.getName()));
		// 3. call the gamesPlayed method and pass the local ArrayList<FootballGame>. 
		
		System.out.println(String.format("%s\tWins: %d\tDraws: %d\tLoses: %d",team.getName(), team.getWins(), team.getDraws(), team.getLoses()));
	}
	/**
	 * Display games played to date
	 * @param games List of games
	 */
	public static void gamesPlayed(ArrayList<FootballGame> games) {
		FootballGame game = null;
		System.out.println();
		System.out.println(String.format("%7s %15s %14s  %5s    %-17s %-12s","Date","Home Team", "Goals", "Goals","Away Team", "Referee"));
		// 1.create a for loop to get the information from the list and use the the toString below to output each game
		//   game is the variable name used for each game
			System.out.println(String.format("%10s  %-18s %5d  %5d    %-18s  %-12s" ,game.getDate(), game.getHomeTeam(), game.getHomeGoals(), game.getAwayGoals(), game.getAwayTeam(), game.getReferee()  ));
		
	}
	/**
	 * Displays the teams ordered by home or away team points sorted by highest to lowest
	 * @param teams List of teams
	 * @param location Home or away location
	 */
	public static void results(ArrayList<Team> teams, String location) {
		//ArrayList<Team> team = new ArrayList<Team>();
		Comparator<Team> comp = new PointsComparator();

		// 1. Assign the appropriate Comparator object to the variable defined above
		
		// 2. Sort the teams by passing the Comparator<Team> variable defined earlier

		System.out.println();
		System.out.println(String.format("   %-18s  %5s  %5s  %5s  %7s","Team", "Wins", "Draws", "Loses", "Points"));
		
		// 3. create a for loop to get the information and use the the toString below to output each team
		//    Notice that if the Comparator<Team> variable is HomeWinsComparator the first output statement is used
		
			if(comp.getClass().getSimpleName().equals("HomeWinsComparator"))
				System.out.println(String.format("%2d %-18s %4d  %5d  %5d  %7d",position++, team.getName(), team.getHomeWins(), team.getHomeDraws(), team.getHomeLoses(),(team.getHomeWins()*3+team.getHomeDraws())));
			else
				System.out.println(String.format("%2d %-18s %4d  %5d  %5d  %7d",position++, team.getName(), team.getAwayWins(), team.getAwayDraws(), team.getAwayLoses(),(team.getAwayWins()*3+team.getAwayDraws())));
		
	}
	/**
	 * Displays the teams ordered by points highest to lowest 
	 * @param teams List of teams
	 */
	public static void results(ArrayList<Team> teams) {
		System.out.println();
		System.out.println("=======================================================================");
		System.out.println(String.format("   %-18s  %6s  %5s  %5s  %5s   +/-    GD %7s","Team", "Played", "Wins", "Draws", "Loses", "Points"));
		System.out.println("=======================================================================");
		// 1. declare variables
		int played, gf, ga, gd, position;
		Team team;
		
		// 2. create a for loop to get the information and use the the toString below to output each team
	
		System.out.println(String.format("%2d %-18s  %4d    %4d %5d  %5d   %3d-%-3d %3d  %4d",position++,  team.getName(), played,team.getWins(), team.getDraws(), team.getLoses(),gf, ga, gd, team.getPoints()));
		
	}
	/**
	 * Download data from URL and create data file
	 */
	public static void createFile() {
		// 1. Declare variables
		// "https://www.football-data.co.uk/mmz4281/2223/E0.csv"
		
		// 2. Create a try/catch block to download the data from the URL above
		// 3. Write the contents to a file called E0.csv

	}
	/**
	 * Displays a list of the teams and permits the user to select one of them
	 * @param teamList the list of teams
	 * @param scan a Scanner object
	 * @return the team selected
	 */
	public static Team getTeam(OrderedArrayList<Team> teamList, Scanner scan) {
		
		// 1. Define variables
		
		// 2. call the sort method in the ArrayList class and pass a new NamesComparator object
		// this will sort the teams in the list by name
		
		// 3. Create a while loop - while flag is false
		
		// 4. Create a loop to display the names of the teams
		
		// 5. Create a try/catch block to permit the user to select one of the names of the teams

		// 6. If the selected name is valid store it in the variable and return it
		//      Otherwise repeat the loop
	
	}
}
