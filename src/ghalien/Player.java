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
* https://www.youtube.com/watch?v=23vDA55bzSg
* https://www.youtube.com/watch?v=s_rX8YfRMyk
*
* Version: 2025-04-27
*/
package ghalien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Purpose: The reponsibility of Player is ...
 *
 * Player is-a ...
 * Player is ...
 */
public class Player extends JComponent implements Moveable
{
	private String name;
	private int x; //horizontal location
	private int y; //vertical location
	private Score score; //a Player has-a score
	
	public Player(String newName)
	{
		//super(newName);
		name = newName;
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
	
	public String toString()
	{
		return name;
	}
	
	/**
	 * Purpose: generates the player as a Blue circle
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval(0, 0, 100, 100);
	}
}
