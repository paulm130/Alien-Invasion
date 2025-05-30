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
* https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
*
* Version: 2025-05-29
*/
package ghalien;

import java.awt.BorderLayout; //help our game be organized!
import java.awt.Color; //used to set text color in JLabels

import javax.swing.JFrame; //able to create a JFrame & have access to JFrame methods
import javax.swing.JLabel; //able to make JLabels for oganization
import javax.swing.JOptionPane; //allow us to have pop up messages
import javax.swing.JPanel; //allow us to make the JFrame neater and break it into smaller parts

//JPanel is crucial to Player & Ship components

/**
 * Purpose: The reponsibility of AlienInvasionView is to "run" the game and make components
 * visible. It also updates our GUI as needed depending on certain game conditions.
 * 
 * AlienInvasionView is a JFrame
 */
public class AlienInvasionView extends JFrame
{
	private Score score; //a AlienInvasionModel has-a score
	private JLabel instructionLabel; //a AlienInvasionModel has-a instructionLabel
	private JLabel scoreLabel; //a AlienInvasionModel has-a scoreLabel
	private PlayerShipPanel mainPanel; //a AlienInvasionView has-a mainPanel
	private Leaderboard leaderboard; //a AlienInvasionView has-a leaderboard
	private String playerName; //a AlienInvasionView has-a playerName
	
	public AlienInvasionView()
	{	
		super("Alien Invasion"); //give JFrame a visible name
		
		//the player inputs their name in a popup window
		playerName = (String)JOptionPane.showInputDialog(this,"Enter your name","Enter name",
				JOptionPane.PLAIN_MESSAGE);

		//if the player did not input a name makes them try again until they succesfully input a name
		while ((playerName == null) || (playerName.length() <= 0)) {
			playerName = JOptionPane.showInputDialog(this,"You must enter a name! Enter your name","Enter name again",
				    JOptionPane.WARNING_MESSAGE);
		}		
		
		leaderboard = new Leaderboard(); //creating a leaderboard
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //will close when the "x" button in corner is clicked
		setSize(800,800); //JFrame is 800 x 800 pixels
		setResizable(false); //don't want people to resize the game! It will mess with how it looks :(
		
		this.setLayout(new BorderLayout());	//JFrame now has the Border layout (NSEW)
		
		//Player panel + ship panel
		mainPanel = new PlayerShipPanel(this); //create panel
		this.add(mainPanel, BorderLayout.CENTER); //PlayerShipPanel is visible on JFrame
		
		//Instructions Panel
		JPanel instructions = new JPanel(); //create panel
		instructionLabel = new JLabel("Use arrow keys to move and click enemy ships to shoot");
		instructions.add(instructionLabel);
		this.add(instructions, BorderLayout.WEST); //Instructions are visible on JFrame
		
		//Score panel
		JPanel scorePanel = new JPanel(); //create panel
		score = new Score(); //create score
		scoreLabel = new JLabel(score.toString()); //label score so people know what it is
		scorePanel.add(scoreLabel);
		this.add(scorePanel, BorderLayout.EAST); //Score is visible on JFrame
		
		//Author label
		JPanel author = new JPanel(); //create panel
		JLabel authorLabel = new JLabel("Programmed by Grace Ho & Paul Montal"); //Let people know the authors :)
		author.add(authorLabel);
		this.add(author, BorderLayout.SOUTH); //Author info visible on JFrame
		setVisible(true); //allow us to see our jframe
	}
	
	/**
	 * Purpose: updates the score and checks if it is gameOver
	 * @param updateType 0 means score update, 1 means lost due to too many aliens, 2 means lost due to collision with spaceShip
	 * @param player the player that will be added to the leaderboard because it is gameOver
	 */
	public void updateGUI(int updateType, Player player)
	{
		switch(updateType)
		{
			//score update
			case 0:	
				score.updateScore();
				scoreLabel.setText(score.toString());
				player.updateScore();
				player.setName(playerName);
				
				if(score.getScore() == 10)
				{
					mainPanel.gameOver();
					JOptionPane.showMessageDialog(null, "You saved Earth from the Aliens! You Win!");
					leaderboard.addPlayer(player);
					leaderboard.outputLeaderboard();
				}
				break;
			
			//lost due to too many aliens
			case 1:
				mainPanel.gameOver();
				JOptionPane.showMessageDialog(null, "Too many Aliens have invaded the Earth. You lose ):");
				player.setName(playerName);
				leaderboard.addPlayer(player);
				leaderboard.outputLeaderboard();
				break;
			
			//lost due to collision
			case 2:
				mainPanel.gameOver();
				JOptionPane.showMessageDialog(null, "You collided with an alien SpaceShip and destroyed your own SpaceShip. You lose ):");
				player.setName(playerName);
				leaderboard.addPlayer(player);
				leaderboard.outputLeaderboard();
				break;
		}
	}
	
	/**
	 * Purpose: sets the color of instructionLabel as red if the player pushes the wrong key
	 */
	public void redInstructionLabel()
	{
		instructionLabel.setForeground(Color.RED);
	}
	
	/**
	 * Purpose: run the game!
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AlienInvasionView(); //initiate class to run game
	}
}