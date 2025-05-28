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
* Version: 2025-05-25
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
		assertEquals(data, "Paul, 9");
		
		//checking that the last 2 items added to the .csv file actually got added last
		while(scan.hasNextLine())
		{
			data = scan.nextLine();
			if(data == "Grace, 0")
			{
				data = scan.nextLine();
				assertEquals(data, "Paul, 0");
				data = scan.nextLine();
				assertEquals(data, "");
			}
		}
		
		scan.close();
	}
	
	@Test
	void testShipMove()
	{
		SpaceShip testShip = new SpaceShip();
		
		testShip.moveLeft();
		assertEquals(99, testShip.getXLocation());
		assertEquals(100,testShip.getYLocation());
		
		testShip.moveRight(400);
		assertEquals(100, testShip.getXLocation());
		assertEquals(100,testShip.getYLocation());
		
		testShip.moveUp();
		assertEquals(99, testShip.getYLocation());
		
		testShip.moveDown(400);
		assertEquals(100, testShip.getYLocation());
	}
	
	@Test
	void playerMove()
	{
		Player testPlayer = new Player();
		
		testPlayer.moveLeft();
		assertEquals(75, testPlayer.getXLocation());
		assertEquals(600,testPlayer.getYLocation());
		
		testPlayer.moveRight(800);
		assertEquals(100, testPlayer.getXLocation());
		assertEquals(600,testPlayer.getYLocation());
		
		testPlayer.moveUp();
		assertEquals(575, testPlayer.getYLocation());
		
		testPlayer.moveDown(800);
		assertEquals(600, testPlayer.getYLocation());
	}
	
	//more tests will be added soon
}
