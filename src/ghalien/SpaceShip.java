/**
* Lead Author(s):
* @author Grace Ho; student ID
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
* Version: 2025-04-28
*/
package ghalien;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Purpose: The reponsibility of SpaceShip is ...
 *
 * SpaceShip is-a ...
 * SpaceShip is ...
 */
public class SpaceShip implements Moveable
{
	private int x; //SpaceShip HAS-A horizontal location
	private int y; //SpaceShip HAS-A vertical location
	private Image shipImage; //SpaceShip HAS-A image
	
	public void drawSpaceShip(Graphics g)
	{
		try
		{
			BufferedImage ship = ImageIO.read(getClass().getResource("spaceship.png"));
			shipImage = ship;
			g.drawImage(shipImage, 100, 100, 150, 150, null);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Purpose: move something to the left
	 */
	public void moveLeft(Graphics g)
	{
		g.drawImage(shipImage, x - 10, y, 150, 150, null);
	}
	
	/**
	 * Purpose: move something to the right
	 */
	public void moveRight(Graphics g)
	{
		g.drawImage(shipImage, x + 10, y, 150, 150, null);
	}
	
	/**
	 * Purpose: move something up
	 */
	public void moveUp(Graphics g)
	{
		g.drawImage(shipImage, x, y + 10, 150, 150, null);
	}
	
	/**
	 * Purpose: move something to the right
	 */
	public void moveDown(Graphics g)
	{
		g.drawImage(shipImage, x, y - 10, 150, 150, null);
	}
	

}