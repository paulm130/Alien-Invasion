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
* Version: 2025-04-27
*/
package ghalien;

import static org.junit.jupiter.api.Assertions.*;

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
		assertEquals("Grace", grace.toString());
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

}
