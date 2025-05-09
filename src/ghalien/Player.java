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
* Interface MouseListener, 
* https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseListener.html
*
* <<Add more references here>>
*
* Version: 2025-05-09
*/
package ghalien;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Purpose: The reponsibility of Player is ...
 *
 * Player is-a ...
 * Player is ...
 */
public class Player implements Moveable
{
	private String name;
	private int x = 400; //player HAS-A horizontal location
	private int y = 400; //player HAS-A vertical location
	private Image playerImage; //player HAS-A image
	private Score score;
	
	/**
	 * Purpose: default constructor
	 */
	public Player()
	{
		name = null;
		score = new Score();
	}
	
	/**
	 * Purpose: constructor
	 * @param newName initializes the name
	 */
	public Player(String newName)
	{
		name = newName;
		score = new Score();
	}
	
	/**
	 * Purpose: sets the value of name
	 * @param newName
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * Purpose: draws out the image of the player
	 * @param g the graphics
	 */
	public void drawPlayerImage(Graphics g)
	{
		try
		{
			BufferedImage player = ImageIO.read(getClass().getResource("player.png"));
			playerImage = player;
			g.drawImage(playerImage, 100, 600, 150, 150,null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Purpose: move something to the left
	 */
	public void moveLeft(Graphics g)
	{
		x -= 50;
		g.drawImage(playerImage, x , y, 150, 150, null);
	}
	
	/**
	 * Purpose: move something to the right
	 */
	public void moveRight(Graphics g)
	{
		x += 50;
		g.drawImage(playerImage, x, y, 150, 150, null);
	}
	
	/**
	 * Purpose: move something up
	 */
	public void moveUp(Graphics g)
	{
		y += 50;
		g.drawImage(playerImage, x, y, 150, 150, null);
	}
	
	/**
	 * Purpose: move something to the right
	 */
	public void moveDown(Graphics g)
	{
		y -= 50;
		g.drawImage(playerImage, x, y, 150, 150, null);
	}
	
	/**
	 * Purpose: 
	 * @return x (horizontal) location
	 */
	public int getXLocation()
	{
		return x;
	}
	
	/**
	 * Purpose: 
	 * @return y (vertical) location
	 */
	public int getYLocation()
	{
		return y;
	}
	
	/**
	 * Purpose: returns the player data as a String. Only printing out the numerical value of the score not the word "score".
	 * @return the player's name and score
	 */
	public String toString()
	{
		String scoreString = score.toString();
		String scoreSubstring = scoreString.substring(scoreString.indexOf(":")+1,scoreString.length());
		return name + "," + scoreSubstring;
	}
	
	/**
	 * Purpose: increments the players score by 1
	 */
	public void updateScore()
	{
		score.updateScore();
	}
}
