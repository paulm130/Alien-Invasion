/**
* Lead Author(s):
* @author Paul Montal; student ID
* @author Grace Ho; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-06-01
*/
package ghalien;

import java.io.File; //Help us deal with our files
import java.io.FileWriter; //Allow us to write to files
import java.io.IOException; //Allow us to handle input output exceptions
import java.io.PrintWriter; //Allow us to write things
import java.util.ArrayList; //Allow us to store data as an ArrayList because we are storing objects of classes we created

/**
 * Purpose: The reponsibility of Leaderboard is ...
 *
 * Leaderboard is-a ...
 * Leaderboard is ...
 */
public class Leaderboard
{
	private ArrayList<Player> players; //a Leaderboard has players
	
	/**
	 * Purpose: default constructor
	 */
	public Leaderboard()
	{
		players = new ArrayList<>(); //create an ArrayList of players
	}
	
	/**
	 * Purpose: adds a player to the leaderboard
	 * @param player the player object that will be stored in array players
	 */
	public void addPlayer(Player player)
	{
		players.add(player);
	}
	
	/**
	 * Purpose: returns the players name and score as a string
	 * @param i the index of the player in the ArrayList players
	 * @return the players name and score as String
	 */
	public String toString(int i)
	{
		Player player = players.get(i); //retrieve certain player from ArrayList at index i
		return player.toString(); //Player's name and score is returned as a String
	}
	
	/**
	 * Purpose: writes the data from the Leaderboard to a .csv output file. Appends data onto whatever is already in leaderboard.
	 */
	public void outputLeaderboard()
	{	
		//allow us to write to our leader board file
		//we are able to append the file and NOT wipe it because of "true"
		//using try-with-resources to make sure outputFileWriter is closed as soon as it is no longer needed.
		try(PrintWriter outputFileWriter = new PrintWriter(new FileWriter(new File("playerData.csv"), true))) 
		{
			for(int i = 0; i < players.size(); i++) //allows us to write info for all Players in the ArrayList
			{
				outputFileWriter.println(this.toString(i)); //write Player info on a new line each time
			}
		}
		catch (IOException e)
		{
			System.out.println("Cannot write file. File will not be written");
			e.printStackTrace();
		}	
	}
}
