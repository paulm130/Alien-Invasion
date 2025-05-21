/**
* Lead Author(s):
* @author Paul Montal; student ID
* @author Full name; student ID
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
* Version: 2025-05-22
*/
package ghalien;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Purpose: The reponsibility of Leaderboard is ...
 *
 * Leaderboard is-a ...
 * Leaderboard is ...
 */
public class Leaderboard
{
	private ArrayList<Player> players; //a Leaderboard has players
	private PrintWriter outputFileWriter; //a Leaderboard has-a outputFileWriter
	
	/**
	 * Purpose: default constructor
	 */
	public Leaderboard()
	{
		players = new ArrayList<>();
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
		Player player = players.get(i);
		return player.toString();
	}
	
	/**
	 * Purpose: writes the data from the Leaderboard to a .csv output file. Appends data onto whatever is already in leaderboard.
	 */
	public void outputLeaderboard()
	{
		
		try 
		{
			outputFileWriter = new PrintWriter(new FileWriter(new File("playerData.csv"), true));
			
			for(int i = 0; i < players.size(); i++)
			{
				outputFileWriter.println(this.toString(i));
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Cannot write file. File will not be written");
			e.printStackTrace();
		}	
		finally
		{
			outputFileWriter.close();
		}
	}
}
