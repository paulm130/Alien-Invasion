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
* Version: 2025-05-22
*/
package ghalien;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Purpose: The reponsibility of PlayerShipPanel is ...
 *
 * PlayerShipPanel is-a ...
 * PlayerShipPanel is ...
 */
public class PlayerShipPanel extends JPanel implements ActionListener, KeyListener, MouseListener
{
	private Timer movementTimer; //a PlayerShipPanel has-a movementTimer
	private Timer newSpaceShipTimer; //a PlayerShipPanel has-a newSpaceShipTimer
	private Player newPlayer; //a PlayerShipPanel has-a newPlayer
	private ArrayList<SpaceShip> spaceShips; //a PlayerShipPanel has-many spaceShips
	private AlienInvasionView alienInvasionView; //a PlayerShipPanel has-a alienInvasionView
	
	/**
	 * Purpose: constructor
	 * @param initAlienInvasionView
	 */
	public PlayerShipPanel(AlienInvasionView initAlienInvasionView)
	{
		setBackground(Color.DARK_GRAY);
		this.alienInvasionView = initAlienInvasionView;
		newPlayer = new Player(); //create player
		spaceShips = new ArrayList<>(); //create array of spaceShips (allows us to have multiple ships)
		spaceShips.add(new SpaceShip()); //create ship and add to array
		

		movementTimer = new Timer(1000/10, this); //will move at 10 frames per second (not like usual 60)	
		movementTimer.start();

		newSpaceShipTimer = new Timer(3000, this); //a new ship will spawn every 3 seconds
		newSpaceShipTimer.start();
		
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
		newPlayer.drawPlayerImage(g); //draw player on screen
		for(int i = 0; i < spaceShips.size(); i++)
		{
			spaceShips.get(i).drawSpaceShip(g);
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
		//when the movementTimer triggers an ActionPerformed each SpaceShip moves in a random direction
		if(e.getSource() == movementTimer)
		{
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
					}
					repaint(); //SpaceShip drawn in new location
				}
			}
			
			//if the player and a SpaceShip collided will update the GUI with gameOver code
			Rectangle player = new Rectangle(newPlayer.getXLocation(), newPlayer.getYLocation(), 150, 150);
			for(int i = 0; i < spaceShips.size(); i++)
			{
				Rectangle spaceShip = new Rectangle(spaceShips.get(i).getXLocation(), spaceShips.get(i).getYLocation(), 150, 150);
				if(player.intersects(spaceShip))
					alienInvasionView.updateGUI(2, newPlayer);
			}
		}
		
		//when the newSpaceShipTimer triggers an ActionPerformed spawn a new SpaceShip in spaceShips
		else
		{
			spaceShips.add(new SpaceShip());
			if(spaceShips.size() >= 5)
				alienInvasionView.updateGUI(1, newPlayer);
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
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
				newPlayer.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				newPlayer.moveRight(getWidth());
				break;
			case KeyEvent.VK_UP:
				newPlayer.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				newPlayer.moveDown(getHeight());
				break;	
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
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
			int shipX = ship.getXLocation();
			int shipY = ship.getYLocation();
			
			if(shotX >= shipX && shotX <= shipX + 150 && shotY >= shipY && shotY <= shipY + 150)
			{
				System.out.println("Shot down SpaceShip " + i);
				spaceShips.remove(i);
				repaint();
				alienInvasionView.updateGUI(0, newPlayer); 
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Purpose: when the player wins or loses stops anything from moving or happening in the game
	 */
	public void gameOver()
	{
		movementTimer.stop();
		newSpaceShipTimer.stop();
		removeKeyListener(this);
		removeMouseListener(this);
	}
}