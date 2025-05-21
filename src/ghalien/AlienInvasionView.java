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
* Version: 2025-05-22
*/
package ghalien;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Purpose: The reponsibility of AlienInvasionView is ...
 *
 * AlienInvasionView is-a ...
 * AlienInvasionView is ...
 */
public class AlienInvasionView extends JFrame
{
	private AlienInvasionModel gameModel; //a AlienInvasionModel has-a gameModel
	private Score score; //a AlienInvasionModel has-a score
	private JLabel scoreLabel; //a AlienInvasionModel has-a scoreLabel
	private PlayerShipPanel mainPanel; //a AlienInvasionView has-a mainPanel
	private Leaderboard leaderboard; //a AlienInvasionView has-a leaderboard
	private String playerName; //a AlienInvasionView has-a playerName
	
	public AlienInvasionView(AlienInvasionModel model)
	{	
		super("Alien Invasion"); //give JFrame a visible name
		
		//player must enter their name before the game begins
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		playerName = scan.nextLine();
		scan.close();
		
		gameModel = model;
		leaderboard = new Leaderboard();
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
		mainPanel = new PlayerShipPanel(this);
		this.add(mainPanel, BorderLayout.CENTER);
		
		//Score panel
		JPanel scorePanel = new JPanel();
		score = new Score();
		scoreLabel = new JLabel(score.toString());
		scorePanel.add(scoreLabel);
		this.add(scorePanel, BorderLayout.EAST);
		
		//Author label
		JPanel author = new JPanel();
		JLabel authorLabel = new JLabel("Programmed by Grace Ho & Paul Montal");
		author.add(authorLabel);
		this.add(author, BorderLayout.SOUTH);
		setVisible(true); //allow us to see our jframe
		
	}
	
	/**
	 * Purpose: updates the score and checks if it is gameOver
	 * @param updateType 0 means score update, 1 means lost due to too many aliens, 2 means lost due to collision with spaceShip
	 * @param player the player that will be added to the leaderboard because if it is gameOver
	 */
	public void updateGUI(int updateType, Player player)
	{
		switch(updateType)
		{
			case 0:	
				score.updateScore();
				scoreLabel.setText(score.toString());
				player.updateScore();
				player.setName(playerName);
				
				if(score.getScore() == 50)
				{
					mainPanel.gameOver();
					JOptionPane.showMessageDialog(null, "You saved Earth from the Aliens! You Win!");
					leaderboard.addPlayer(player);
					leaderboard.outputLeaderboard();
				}
				break;
				
			case 1:
				mainPanel.gameOver();
				JOptionPane.showMessageDialog(null, "Too many Aliens have invaded the Earth. You lose ):");
				leaderboard.addPlayer(player);
				leaderboard.outputLeaderboard();
				break;
			
			case 2:
				mainPanel.gameOver();
				JOptionPane.showMessageDialog(null, "You collided with an alien SpaceShip and destroyed your own SpaceShip. You lose ):");
				leaderboard.addPlayer(player);
				leaderboard.outputLeaderboard();
				break;
		}
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