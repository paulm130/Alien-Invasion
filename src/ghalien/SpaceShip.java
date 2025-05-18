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
* Version: 2025-05-17
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
	
	/**
	 * Purpose: constructor 
	 */
	public SpaceShip()
	{
		x = 100;
		y = 100;
	}
	
	public void drawSpaceShip(Graphics g)
	{
		try
		{
			BufferedImage ship = ImageIO.read(getClass().getResource("spaceship.png"));
			shipImage = ship;
			g.drawImage(shipImage, x, y, 150, 150, null);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void moveLeft()
	{
		// TODO Auto-generated method stub
		if(x >= 100)
			x -= 100;
	}

	@Override
	public void moveRight(int panelWidth)
	{
		// TODO Auto-generated method stub
		if(x + 250 <= panelWidth)
			x += 100;
	}

	@Override
	public void moveUp()
	{
		// TODO Auto-generated method stub
		if(y >= 100)
			y -= 100;
	}

	@Override
	public void moveDown(int panelHeight)
	{
		// TODO Auto-generated method stub
		if(y + 250 <= panelHeight)
			y += 100;

	}
}