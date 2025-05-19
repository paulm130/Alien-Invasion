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
*
* Version: 2025-05-18
*/
package ghalien;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private ArrayList<SpaceShip> spaceShips; //a PlayerShipPanel has spaceShips
	private AlienInvasionView alienInvasionView; //a PlayerShipPanel has-a alienInvasionView
	
	/**
	 * Purpose: constructor
	 * @param initAlienInvasionView
	 */
	public PlayerShipPanel(AlienInvasionView initAlienInvasionView)
	{
		setBackground(Color.DARK_GRAY);
		this.alienInvasionView = initAlienInvasionView;
		newPlayer = new Player();
		spaceShips = new ArrayList<>();
		spaceShips.add(new SpaceShip());
		
		movementTimer = new Timer(10, this);		
		movementTimer.start();
		
		newSpaceShipTimer = new Timer(3000, this);
		newSpaceShipTimer.start();
		
		//setting up KeyListener
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		newPlayer.drawPlayerImage(g);
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
		
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		//when the movementTimer triggers an ActionPerformed each SpaceShip moves in a random direction
		if(e.getSource() == movementTimer)
		{
			Random randomizer = new Random();
			
			for(int i = 0; i < spaceShips.size(); i++)
			{
				int randomNumber = randomizer.nextInt(4);
				switch(randomNumber) 
				{
					case 0:
						spaceShips.get(i).moveLeft();
						this.paintComponent(getGraphics());
						break;
					case 1:
						spaceShips.get(i).moveRight(getWidth());
						this.paintComponent(getGraphics());
						break;
					case 2:
						spaceShips.get(i).moveUp();
						this.paintComponent(getGraphics());
						break;
					case 3:
						spaceShips.get(i).moveDown(getHeight());
						this.paintComponent(getGraphics());
						break;
				}
			}
			
			//if the player and a SpaceShip collided will update the GUI with gameOver code
			Rectangle player = new Rectangle(newPlayer.getXLocation(), newPlayer.getYLocation(), 150, 150);
			for(int i = 0; i < spaceShips.size(); i++)
			{
				Rectangle spaceShip = new Rectangle(spaceShips.get(i).getXLocation(), spaceShips.get(i).getYLocation(), 150, 150);
				if(player.intersects(spaceShip))
					alienInvasionView.updateGUI(2);
			}
			
			repaint();
		}
		
		//when the newSpaceShipTimer triggers an ActionPerformed spawn a new SpaceShip in spaceShips
		else
		{
			spaceShips.add(new SpaceShip());
			if(spaceShips.size() >= 5)
				alienInvasionView.updateGUI(1);
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
		//when a key is pressed moves the player
		int keyCode = e.getKeyCode();
		
		switch(keyCode)
		{
			case KeyEvent.VK_LEFT:
				newPlayer.moveLeft();
				this.paintComponent(getGraphics());
				break;
			case KeyEvent.VK_RIGHT:
				newPlayer.moveRight(getWidth());
				this.paintComponent(getGraphics());
				break;
			case KeyEvent.VK_UP:
				newPlayer.moveUp();
				this.paintComponent(getGraphics());
				break;
			case KeyEvent.VK_DOWN:
				newPlayer.moveDown(getHeight());
				this.paintComponent(getGraphics());
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
		// TODO Auto-generated method stub
		
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
				alienInvasionView.updateGUI(0); 
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