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
* Version: 2025-04-21
*/
package ghalien;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Purpose: The reponsibility of SpaceShip is ...
 *
 * SpaceShip is-a ...
 * SpaceShip is ...
 */
public class SpaceShip extends JButton implements Moveable
{
	private int x;
	private int y; 
	private ImageIcon shipIcon = new ImageIcon("tempspaceship.jpg", "space ship");
	public SpaceShip()
	{
		setIcon(shipIcon);
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

}
