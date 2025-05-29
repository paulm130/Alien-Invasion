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
* Version: 2025-05-18
*/
package ghalien;

import java.awt.Graphics; //allow us to draw the ship so it is visible
import java.awt.Image; //allow us to have a usable image to be drawn
import java.awt.image.BufferedImage; //allow us to load image data into a variable
import java.io.IOException; //allow us to handle Input OutPut exceptiosn since we are dealing with files

import javax.imageio.ImageIO; //allow us to read image data

/**
 * Purpose: The reponsibility of SpaceShip is to handle SpaceShip movement and be visible on screen
 * SpaceShip IS Moveable
 */
public class SpaceShip implements Moveable
{
	private int x; //SpaceShip HAS-A horizontal location
	private int y; //SpaceShip HAS-A vertical location
	private Image shipImage; //SpaceShip HAS-A image
	
	/**
	 * Purpose: constructor 
	 */
	public SpaceShip()
	{
		x = 100; //initial starting point for x coordinate
		y = 100; //inital starting point for y coordinate
	}
	
	public void drawSpaceShip(Graphics g)
	{
		try
		{
			BufferedImage ship = ImageIO.read(getClass().getResource("spaceship.png")); //load image
			shipImage = ship; //set shipImage to address of ship variable because drawImage method only takes Image variables
			g.drawImage(shipImage, getXLocation(), getYLocation(), 150, 150, null); //draw space ship image at specific location
		}
		catch (IOException e)
		{
			e.printStackTrace(); //tell us what went wrong
		}
	}

	/**
	 * Purpose: move left by 1
	 */
	@Override
	public void moveLeft()
	{
		if(x >= 100)
			x --;
	}

	/**
	 * Purpose: move right by 1
	 */
	@Override
	public void moveRight(int panelWidth)
	{
		// TODO Auto-generated method stub
		if(x + 250 <= panelWidth)
			x ++;
	}

	/**
	 * Purpose: move up by 1
	 */
	@Override
	public void moveUp()
	{
		// TODO Auto-generated method stub
		if(y >= 100)
			y --;
	}

	/**
	 * Purpose: move down by 1
	 */
	@Override
	public void moveDown(int panelHeight)
	{
		// TODO Auto-generated method stub
		if(y + 250 <= panelHeight)
			y ++;
	}
	
	/**
	 * Purpose: returns x(horizontal) location
	 * @return x
	 */
	public int getXLocation()
	{
		return x;
	}
	
	/**
	 * Purpose: returns y(vertical) location
	 * @return y
	 */
	public int getYLocation()
	{
		return y;
	}
	
}