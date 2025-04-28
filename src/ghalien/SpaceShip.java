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
* Version: 2025-04-21
*/
package ghalien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * Purpose: The reponsibility of SpaceShip is ...
 *
 * SpaceShip is-a ...
 * SpaceShip is ...
 */
public class SpaceShip extends JComponent implements Moveable
{
	private int x;
	private int y; 
	private ImageIcon shipIcon = new ImageIcon("tempspaceship.jpg", "space ship");
	public SpaceShip()
	{
		setPreferredSize(new Dimension(100, 100));
	}
	
	/** 
	 * I still have to figure this out it shouldn't be hard
	 * @return the x(horizontal) position of the Player
	 */
	public int getXPosition()
	{
		return 0;
	}
	
	/** 
	 * I still have to figure this out it shouldn't be hard
	 * @return the y(vertical) position of the Player
	 */
	public int getYPosition()
	{
		return 0;
	}
	
	/**
	 * Purpose: move something to the left
	 */
	public void moveLeft()
	{
		setLocation(x - 10, y);
	}
	
	/**
	 * Purpose: move something to the right
	 */
	public void moveRight()
	{
		setLocation(x + 10, y);
	}
	
	/**
	 * Purpose: move something up
	 */
	public void moveUp()
	{
		setLocation(x, y + 10);
	}
	
	/**
	 * Purpose: move something to the right
	 */
	public void moveDown()
	{
		setLocation(x, y - 10);
	}
	
	/**
	 * Purpose: generates the SpaceShip using shipIcon. 
	 * I am still trying to figure out how to get it to work here is a youtube video. 
	 * https://www.youtube.com/watch?v=dFOIoX3fXpQ
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(shipIcon.getImage(), 0,0, 100, 100, this);
	}

}
