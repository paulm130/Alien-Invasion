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
* https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyListener.html
* https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseListener.html
* https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
*
* Version: 2025-05-29
*/
package ghalien;

import java.awt.Color; //allow us to use different colors
import java.awt.Graphics; //allow us to draw and repaint components on the JPanel
import java.awt.Rectangle; //allow us to create Rectangles; we create "hit boxes" to register collisions and shots fired
import java.awt.event.ActionEvent; //allow us to have an event that can be executed (related to our timer)
import java.awt.event.ActionListener; //necessary in conjunction w/ ActionEvent so it ActionEvent will execute
import java.awt.event.KeyEvent; //allow us to have an even executed if a certain key is used
import java.awt.event.KeyListener; //necessary in conjunction w/ KeyEvent so KeyEvents actually occur
import java.awt.event.MouseEvent; //allow us to have an event executed if mouse is used
import java.awt.event.MouseListener; //necessary in conjunction w/ MouseEvent so events occur
import java.awt.image.BufferedImage; //allow us to load in images
import java.awt.Image; //allow us to use our loaded images with the draw method of the Graphics class
import java.io.IOException; //allow us to handle InputOutput Exceptions if and when they occur
import java.util.ArrayList; //allow us to store objects form our own custom classes
import java.util.Random; //allow us to randomly generate numbers (necessary for randomizing ship movement)

import javax.imageio.ImageIO; //necessary in reading image file data
import javax.swing.JPanel; //allow us to later add an instantiation of this class to our JFrame
//also allows us to customize this section of our game
import javax.swing.Timer; //allow us to execute ActionEvents at certain time periods

/**
 * Purpose: The reponsibility of PlayerShipPanel is to house all methods related to game such as:
 * Customizing look of main game component (this panel)
 * Paint components so space ships and the player are visible
 * Allow the space ship and player to move and have that movement visible on screen
 * Allow player to shoot and collide with ships
 * 
 * PlayerShipPanel IS-A JPanel
 * PlayerShipPanel IS able to Listen to Actions (ActionListener) and then execute ActionEvents
 * PlayerShipPanel IS able to listen to Keys (KeyListener) and then execute KeyEvents
 * PlayerShipPanel IS able to listen to the Mouse (MouseListener) and then execute MouseEvents
 */
public class PlayerShipPanel extends JPanel implements ActionListener, KeyListener, MouseListener
{
	private Timer timer; //a PlayerShipPanel has-a timer
	private Player player; //a PlayerShipPanel has-a player
	private ArrayList<SpaceShip> spaceShips; //a PlayerShipPanel has-many spaceShips
	private AlienInvasionView alienInvasionView; //a PlayerShipPanel has-a alienInvasionView
	private int actionCounter; //a PlayerShipPanel has-a actionCounter
	private int shipX = 0; //PlayerShipPanel has-a (records) the ship's x coordinate
	private int shipY = 0; //PlayerShipPanel has-a (records) the ship's coordinate
	private Image shotImage; //PlayerShipPanel has-a shot image
	private int shotStatus = 0; //PlayerShipPanel has-a shotStatus
	
	/**
	 * Purpose: constructor
	 * @param initAlienInvasionView
	 */
	public PlayerShipPanel(AlienInvasionView initAlienInvasionView)
	{
		setBackground(Color.DARK_GRAY); //change background color
		this.alienInvasionView = initAlienInvasionView; //have access to methods in AlienInvasionView
		player = new Player(); //create player
		spaceShips = new ArrayList<>(); //create array of spaceShips (allows us to have multiple ships)
		spaceShips.add(new SpaceShip()); //create ship and add to array
		

		timer = new Timer(1000/10, this); //will move at 10 frames per second (not like usual 60)	
		timer.start();
		
		//setting up KeyListener
		setFocusable(true); //if not focused, will not read key input
		requestFocusInWindow();
		addKeyListener(this); //will listen to keys and react based on what we coded
		
		addMouseListener(this); //will listen to mouse based on what we coded
	}
	
	/**
	 * Purpose:
	 * @param g part of Graphics class, allows us access to Graphics methods
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		player.drawPlayerImage(g); //draw player on screen
		if(shotStatus == 1)
		{
			try
			{
				BufferedImage shot = ImageIO.read(getClass().getResource("Shot.png")); //load and read shot image data
				shotImage = shot;
				g.drawImage(shotImage, shipX, shipY, 150, 150,null); //draw shot image on screen so it's visible
				shotStatus = 0; //reset shot status
			}
			catch (IOException e)
			{
				e.printStackTrace(); //tell us what went wrong
			}
		}
		for(int i = 0; i < spaceShips.size(); i++)
		{
			spaceShips.get(i).drawSpaceShip(g); //draw a ship so it is visible
		}
//			try
//			{
				
				
				//fail-safe code don't delete
//				BufferedImage player = ImageIO.read(getClass().getResource("player.png"));
//				Image playerImage = player;
//				g.drawImage(playerImage, 100, 600, 150, 150,null);
//				BufferedImage ship = ImageIO.read(getClass().getResource("spaceship.png"));
//				Image shipImage = ship;
//				g.drawImage(shipImage, 100, 100, 150, 150, null);
//			}
//			catch (IOException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}
		
	
	/**
	 * Purpose: Move spaceship
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		actionCounter++; //increment the actionCounter each time there is an action
		Random randomizer = new Random(); //create randomizer for random numbers	
		for(int i = 0; i < spaceShips.size(); i++)
		{
			int randomNumber = randomizer.nextInt(4); //get numbers 0 - 3
			for (int j = 0; j < 50; j++) //move a certain direction 50 times
			{
				switch(randomNumber) 
				{
					case 0:
						spaceShips.get(i).moveLeft();
						break;
					case 1:
						spaceShips.get(i).moveRight(getWidth());
						break;
					case 2:
						spaceShips.get(i).moveUp();
						break;
					case 3:
						spaceShips.get(i).moveDown(getHeight());
						break;
					default:
						System.out.println("Error cannot move SpaceShip " + i); //error message if can't move SpaceShip
						break;
				}
				repaint(); //SpaceShip drawn in new location
			}
		}
		
		//if the player and a SpaceShip collided will update the GUI with gameOver code
		Rectangle playerRectangle = new Rectangle(player.getXLocation(), player.getYLocation(), 150, 150);
		for(int i = 0; i < spaceShips.size(); i++)
		{
			Rectangle spaceShip = new Rectangle(spaceShips.get(i).getXLocation(), spaceShips.get(i).getYLocation(), 150, 150);
			if(playerRectangle.intersects(spaceShip))
				alienInvasionView.updateGUI(2, player);
		}
		
		//if there has been 30 actions(3 seconds) make a new spaceship
		if(actionCounter == 30)
		{
			spaceShips.add(new SpaceShip());
			actionCounter = 0; //reset the actionCounter
			if(spaceShips.size() >= 5)
				alienInvasionView.updateGUI(1, player);
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e)
	{
		// this method is empty!
		//because we are implementing the KeyListener and using the KeyEvents class this is a required method that we must have
		//however we don't actually use this method in any of our code so it is empty :(
		//it is not necessary in our game play
		
	}

	/**
	 * Purpose: Move the player
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		//when a key is pressed moves the player
		int keyCode = e.getKeyCode();
		
		//keys and movement are related appropriately
		switch(keyCode)
		{
			case KeyEvent.VK_LEFT:
				player.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				player.moveRight(getWidth());
				break;
			case KeyEvent.VK_UP:
				player.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				player.moveDown(getHeight());
				break;	
			default:
				alienInvasionView.redInstructionLabel(); //if the player pushes the wrong key make the instruction label red so the player knows
				break;
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// this method is empty!
		//because we are implementing the KeyListener and using the KeyEvents class this is a required method that we must have
		//however we don't actually use this method in any of our code so it is empty :(
		//it is not necessary in our game play
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		//when a shot is fired determine where it was fired and if it hit a SpaceShip
		int shotX = e.getX();
		int shotY = e.getY();
		
		for(int i = 0; i < spaceShips.size(); i++)
		{
			SpaceShip ship = spaceShips.get(i);
			shipX = ship.getXLocation();
			shipY = ship.getYLocation();
			
			if(shotX >= shipX && shotX <= shipX + 150 && shotY >= shipY && shotY <= shipY + 150)
			{
				shotStatus =  1;
				spaceShips.remove(i);
				repaint();
				alienInvasionView.updateGUI(0, player); 
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// this method is empty!
		//because we are implementing the MouseListener and MouseEvent class this is a required method that we must have
		//however we don't actually use this method in any of our code so it is empty :(
		//we don't have/want anything happening when the mouth is "pressed" down for periods of time
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// this method is empty!
		//because we are implementing the MouseListener and MouseEvent class this is a required method that we must have
		//however we don't actually use this method in any of our code so it is empty :(
		//because we don't have anything happening when the mouse is pressed,
		//we also don't have anything happening when the mouse is released!
		//it is not relevant to our game
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// this method is empty!
		//because we are implementing the MouseListener class this is a required method that we must have
		//however we don't actually use this method in any of our code so it is empty :(
		//our game does not require something to happen if mouse is entered
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// this method is empty!
		//because we are implementing the MouseListener class this is a required method that we must have
		//however we don't actually use this method in any of our code so it is empty :(
		//our game does not have something happen if mouse is exited
		
	}
	
	/**
	 * Purpose: when the player wins or loses stops anything from moving or happening in the game
	 */
	public void gameOver()
	{
		timer.stop();
		removeKeyListener(this);
		removeMouseListener(this);
	}
}