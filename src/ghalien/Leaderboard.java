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
* Version: 2025-05-02
*/
package ghalien;

import java.io.FileNotFoundException;
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
	
	//adding file I/O in this class eventually
	
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
	 * Purpose: writes the leaderboard data to a csv file. I have not tested this yet so it probably does not work right
	 */
	public void outputLeaderboard()
	{
		
		try 
		{
			outputFileWriter = new PrintWriter("playerData.csv");
			for(int i = 0; i < players.size(); i++)
			{
				outputFileWriter.println(this.toString(i));
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot write file. File will not be written");
		}	
		finally
		{
			outputFileWriter.close();
		}
	}
}
