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

import java.awt.BorderLayout; //help our game be organized!
import java.util.Scanner; //help us read input (for leaderboard)

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
	private AlienInvasionModel gameModel; //a AlienInvasionModel has-a gameModel
	private Score score; //a AlienInvasionModel has-a score
	private JLabel scoreLabel; //a AlienInvasionModel has-a scoreLabel
	private PlayerShipPanel mainPanel; //a AlienInvasionView has-a mainPanel
	private Leaderboard leaderboard; //a AlienInvasionView has-a leaderboard
	private String playerName; //a AlienInvasionView has-a playerName
	
	public AlienInvasionView()
	{	
		super("Alien Invasion"); //give JFrame a visible name
		
		//player must enter their name before the game begins
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		playerName = scan.nextLine(); //get info that player provided
		scan.close(); //must close scanner!
		
		leaderboard = new Leaderboard();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //will close when the "x" button in corner is clicked
		setSize(800,800); //JFrame is 800 x 800 pixels
		setResizable(false); //don't want people to resize the game! It will mess with how it looks :(
		
		this.setLayout(new BorderLayout());	//JFrame now has the Border layout (NSEW)
		
		//Instructions Panel
		JPanel instructions = new JPanel(); //create panel
		JLabel instructionLabel = new JLabel("Use arrow keys to move");
		instructions.add(instructionLabel);
		this.add(instructions, BorderLayout.WEST); //Instructions are visible on JFrame
		
		//Player panel + ship panel
		mainPanel = new PlayerShipPanel(this); //create panel
		this.add(mainPanel, BorderLayout.CENTER); //PlayerShipPanel is visible on JFrame
		
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
				
				if(score.getScore() == 50)
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
				leaderboard.addPlayer(player);
				leaderboard.outputLeaderboard();
				break;
			
			//lost due to collision
			case 2:
				mainPanel.gameOver();
				JOptionPane.showMessageDialog(null, "You collided with an alien SpaceShip and destroyed your own SpaceShip. You lose ):");
				leaderboard.addPlayer(player);
				leaderboard.outputLeaderboard();
				break;
		}
	}
	/**
	 * Purpose: run the game!
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AlienInvasionView();
	}
}