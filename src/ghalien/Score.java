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
* Version: 2025-04-27
*/
package ghalien;

public class Score
{
	private int score;//a Score HAS-A counter for points
	
	/**
	 * Purpose: constructor initializes score to 0
	 */
	public Score() 
	{
		score = 0;
	}
	
	public Score(int newScore)
	{
		score = newScore;
	}
	
	/**
	 * @return the value of score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Purpose: increments the score
	 */
	public void updateScore()
	{
		score++;
	}
	
	public void setScore(int givenScore)
	{
		score = givenScore;
	}
	
	/**
	 * @return the value of score as a String
	 */
	public String toString()
	{
		return "Score: " + score;
	}
}
