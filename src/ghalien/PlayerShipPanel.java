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
*
* Version: 2025-05-17
*/
package ghalien;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
public class PlayerShipPanel extends JPanel implements ActionListener, KeyListener
{
	private Timer movementTimer; //a PlayerShipPanel has-a movementTimer
	private Timer newSpaceShipTimer; //a PlayerShipPanel has-a newSpaceShipTimer
	private Player newPlayer;
	private SpaceShip newShip;
	
	/**
	 * Purpose: constructor
	 */
	public PlayerShipPanel()
	{
		setBackground(Color.DARK_GRAY);
		newPlayer = new Player();
		newShip = new SpaceShip();
		movementTimer = new Timer(10, this);		
		movementTimer.start();
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		newPlayer.drawPlayerImage(g);
		newShip.drawSpaceShip(g);
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
		
		//when the timer triggers an ActionPerformed the SpaceShip moves in a random direction
		Random randomizer = new Random();
		int randomNumber = randomizer.nextInt(4);
		switch(randomNumber) 
		{
			case 0:
				newShip.moveLeft();
				this.paintComponent(getGraphics());
				break;
			case 1:
				newShip.moveRight(getWidth());
				this.paintComponent(getGraphics());
				break;
			case 2:
				newShip.moveUp();
				this.paintComponent(getGraphics());
				break;
			case 3:
				newShip.moveDown(getHeight());
				this.paintComponent(getGraphics());
				break;
		}
		
		repaint();
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
				System.out.println("left");
				newPlayer.moveLeft();
				this.paintComponent(getGraphics());
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("right");
				newPlayer.moveRight(getWidth());
				this.paintComponent(getGraphics());
				break;
			case KeyEvent.VK_UP:
				System.out.println("up");
				newPlayer.moveUp();
				this.paintComponent(getGraphics());
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("down");
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
	
	

}