/**
* Lead Author(s):
* @author Grace Ho; student ID
* @author Paul Montal; student ID
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
* Version: 2025-05-08
*/
package ghalien;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * Purpose: The reponsibility of TestAlienInvasion is ...
 *
 * TestAlienInvasion is-a ...
 * TestAlienInvasion is ...
 */
class TestAlienInvasion
{

	@Test
	void testPlayer()
	{
		Player grace = new Player("Grace");
		assertEquals("Grace, 0", grace.toString());
	}
	
	@Test
	void testScore()
	{
		Score score = new Score();
		assertEquals(score.getScore(), 0);
		assertEquals(score.toString(), "Score: 0");
		score.updateScore();
		assertEquals(score.getScore(), 1);
		assertEquals(score.toString(), "Score: 1");
	}
	
	@Test
	void testLeaderboard() throws FileNotFoundException
	{
		Player grace = new Player("Grace");
		Player paul = new Player("Paul");
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.addPlayer(grace);
		assertEquals(leaderboard.toString(0), "Grace, 0");
		leaderboard.addPlayer(paul);
		assertEquals(leaderboard.toString(1), "Paul, 0");
		
		//testing that data was written to the file correctly
		leaderboard.outputLeaderboard();
		File myFile = new File("playerData.csv");
		Scanner scan = new Scanner(myFile);
		String data = scan.nextLine();
		assertEquals(data, "Name, Score");
		data = scan.nextLine();
		assertEquals(data, "Grace, 0");
		data = scan.nextLine();
		assertEquals(data, "Paul, 0");
		scan.close();
	}
	
	//more tests will be added soon
}
