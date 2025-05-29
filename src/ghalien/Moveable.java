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


/**
 * Purpose: The reponsibility of Moveable is to outline the methods needed for anything that needs to move
 */
public interface Moveable
{
	/**
	 * Purpose: move something to the left
	 */
	void moveLeft();
	
	/**
	 * Purpose: move something to the right
	 * @param panelWidth helps us know the wall of our panel
	 */
	void moveRight(int panelWidth);
	
	/**
	 * Purpose: move something up
	 */
	void moveUp();
	
	/**
	 * Purpose: move something down
	 * @param panelHeight helps us know the wall of our panel
	 */
	void moveDown(int panelHeight);
}
