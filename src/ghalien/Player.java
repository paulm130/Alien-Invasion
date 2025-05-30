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
* https://www.youtube.com/watch?v=wT9uNGzMEM4
*
* Version: 2025-05-20
*/
package ghalien;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Purpose: The reponsibility of Player is to record a name and have a visible image that the Player will use
 * Player is moveable
 */
public class Player implements Moveable
{
	private String name; //Player HAS-A name
	private int x; //Player HAS-A horizontal location
	private int y; //Player HAS-A vertical location
	private Image playerImage; //Player HAS-A image
	private Score score; //Player HAS-A score
	
	/**
	 * Purpose: default constructor
	 */
	public Player()
	{
		name = null; //initially set to null
		score = new Score(); //initiate creation of Score variable
		x = 100; //preset x coordinate
		y = 600; //preset y coordinate
	}
	
	/**
	 * Purpose: constructor
	 * @param newName initializes the name
	 */
	public Player(String newName)
	{
		name = newName; //Player has a name based on information provided
		score = new Score(); //initiate creation of Score variable
		x = 100; //preset x coordinate
		y = 600; //preset y coordinate
	}
	
	public Player(Player copyPlayer)
	{
		name = copyPlayer.getName();
		score = new Score(copyPlayer.getPlayerScore());
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
			BufferedImage player = ImageIO.read(getClass().getResource("player.png")); //load image in
			playerImage = player; //set playerImage to the address of player because drawImage method only takes Image variables
			g.drawImage(playerImage, x, y, 150, 150,null); //draws image so it is visible
		}
		catch (IOException e)
		{
			e.printStackTrace(); //let us know what went wrong
		}
	}
	
	@Override
	/**
	 * Purpose: move something to the left
	 */
	public void moveLeft()
	{
		if(x >= 25)
			x -= 25; //decrement x location by by 25
	}

	/**
	 * Purpose: move something to the right
	 * @param panelWidth helps us know the wall of our panel
	 */
	@Override
	public void moveRight(int panelWidth)
	{
		if(x + 175 <= panelWidth)
			x += 25; //increment x location by 25
	}

	@Override
	/**
	 * Purpose: move something up
	 */
	public void moveUp()
	{
		if(y >= 25)
			y -= 25; //derement y location by 25
	}

	@Override
	/**
	 * Purpose: move something down
	 * @param panelHeight helps us know the wall of our panel
	 */
	public void moveDown(int panelHeight)
	{
		if(y + 175 <= panelHeight)
			y += 25; //increment y location by 25

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
	 * Purpose:
	 * @return Score of player
	 */
	public int getPlayerScore()
	{
		return score.getScore();
	}
	
	/**
	 * Purpose
	 * @return name of player
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Purpose: returns the player data as a String. Only printing out the numerical value of the score not the word "score".
	 * @return the player's name and score
	 */
	public String toString()
	{
		String scoreString = score.toString(); //get Score information in String format
		String scoreSubstring = scoreString.substring((scoreString.indexOf(":")+2),scoreString.length());//just get Score number from scoreString
		return name + "," + scoreSubstring; //combine name and Score number in one string
	}
	
	/**
	 * Purpose: increments the players score by 1
	 */
	public void updateScore()
	{
		score.updateScore();
	}
	
	public void setScore(int givenScore)
	{
		score = new Score();
		score.setScore(givenScore);
	}
}
