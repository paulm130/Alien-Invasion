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
* Version: 2025-04-28
*/
package ghalien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Purpose: The reponsibility of AlienInvasionView is ...
 *
 * AlienInvasionView is-a ...
 * AlienInvasionView is ...
 */
public class AlienInvasionView extends JFrame
{
	private AlienInvasionModel gameModel;
	
	public AlienInvasionView(AlienInvasionModel model)
	{
		super("Alien Invasion"); //give JFrame a visible name
		gameModel = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //will close when the "x" button in corner is clicked
		setSize(800,800);
		setResizable(false);
		
		this.setLayout(new BorderLayout());	//JFrame now has the Border layout (NSEW)
		
		//Instructions Panel
		JPanel instructions = new JPanel();
		JLabel instructionLabel = new JLabel("Use arrow keys to move");
		instructions.add(instructionLabel);
		this.add(instructions, BorderLayout.WEST);
		
		//Player panel + ship panel
		PlayerShipPanel mainPanel = new PlayerShipPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
		//Score panel
		JPanel scorePanel = new JPanel();
		Score score = new Score();
		JLabel scoreLabel = new JLabel(score.toString());
		scorePanel.add(scoreLabel);
		this.add(scorePanel, BorderLayout.EAST);
		
		//Author label
		JPanel author = new JPanel();
		JLabel authorLabel = new JLabel("Programmed by Grace Ho & Paul Montal");
		author.add(authorLabel);
		this.add(author, BorderLayout.SOUTH);
		setVisible(true); //allow us to see our jframe
		
	}
	
	public void updateGUI(Graphics g)
	{
		
	}
	/**
	 * Purpose: 
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AlienInvasionView(new AlienInvasionModel());
	}

}