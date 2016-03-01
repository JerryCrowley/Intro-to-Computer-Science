/* Author:  Jeremiah Crowley
   Date:    11/28/2012
   Section: CS101, Section 02, Fall 2012
*/

package spaceinvaders;

import processing.core.PApplet;
import processing.core.PFont;

public class SpaceInvaders extends PApplet 
{
		// the user controlled player
		Player thePlayer;
		int playerMovementDirection = 0;

		// the user controlled missile
		Missile missile;
		
		AlienMissile AlienMissile; 

		// our aliens
		Alien[] theAliens;

		boolean keepgoing = false;
		

		int state = 1;
		int points = 0;
		
		int wins = 0;
		int losses = 0;
		
		public void setup() 
		{
			// set the size of our graphics canvas
			size(1000, 300);
			
			// smooth all drawing
			smooth();
			
			// draw all rectangles from their center points
			rectMode(CENTER);
			
			// create a new instance of our Player class
			this.thePlayer = new Player(this.width/2, this.height-25, this);
						
			// create a new instance of our Missile class
			// (the player only gets one missile - if they shoot more than one then we
			// simply take the one in flight and bring it back down so that it can fire again)
			this.missile = new Missile(0,-50,this);
			this.AlienMissile = new AlienMissile(  (int)Math.random() * 10 + 1,(int)Math.random() * 10 + 1,this  );
						
			// create two new aliens
			this.theAliens = new Alien[20];
			this.theAliens[0] = new BlueAlien(0, 25, this);
			this.theAliens[1] = new BlueAlien(50, 25, this);
			this.theAliens[2] = new BlueAlien(100, 25, this);
			this.theAliens[3] = new BlueAlien(150, 25, this);
			this.theAliens[4] = new BlueAlien(200, 25, this);
			this.theAliens[5] = new PurpleAlien(0, 50, this);
			this.theAliens[6] = new PurpleAlien(50, 50, this);
			this.theAliens[7] = new PurpleAlien(100, 50, this);
			this.theAliens[8] = new PurpleAlien(150, 50, this);
			this.theAliens[9] = new PurpleAlien(200, 50, this);
			this.theAliens[10] = new RedAlien(0, 75, this);
			this.theAliens[11] = new RedAlien(50, 75, this);
			this.theAliens[12] = new RedAlien(100, 75, this);
			this.theAliens[13] = new RedAlien(150, 75, this);
			this.theAliens[14] = new RedAlien(200, 75, this);
			this.theAliens[15] = new OrangeAlien(0, 100, this);
			this.theAliens[16] = new OrangeAlien(50, 100, this);
			this.theAliens[17] = new OrangeAlien(100, 100, this);
			this.theAliens[18] = new OrangeAlien(150, 100, this);
			this.theAliens[19] = new OrangeAlien(200, 100, this);

			
			
			// load in our font so that we can draw text to the screen
			PFont genericFont = loadFont("sansSerifFont24.vlw");
						
			// set the default font as the one we just loaded
			this.textFont( genericFont );
		}
		

		public void draw() 
		{
	
			if (this.state == 1)
			{
				this.points = 0;
				this.keepgoing = false;
				
				background(0);
				
				// load in our font so that we can draw text to the screen
				PFont genericFont = loadFont("sansSerifFont24.vlw");
				
				// set the default font as the one we just loaded
				this.textFont( genericFont );
				
				
				// title text
				fill(255);
				text("Space Invaders!", 400, 100);
				
				text("Press any key to continue", 350, 150);
				
				text("Wins: " + this.wins, 25, 260);
				text("Losses: " + this.losses, 25, 290);
				
				if (keyPressed == true) 
				{
					this.state ++;
				}

			}
			
			if (this.state == 2)
			{
				// erase the background
				background(0);
					
				// score text
				fill(255);
				text("Score: " + this.points,800,25);
				
							
				// iterate over all aliens
				for (int i = 0; i < this.theAliens.length; i++)
				{
					// tell each one to move
					this.theAliens[i].move();
						
					// check each alien to see if the missile hit them
					// if so the alien will flip its own "alive" variable to false
					boolean hit = this.theAliens[i].missileHitTest(this.missile.x,  this.missile.y);
						
					// you could do something with "hit" here if you needed to react to an alien being hit
		
					if (hit == true)
					{
						this.points ++;
						
					}
					
					// display each alien
					this.theAliens[i].display();
				}
						
				// move and display the missile
				this.missile.move();
				this.missile.display();
				
				// move and display the player
				this.thePlayer.move(this.playerMovementDirection);
				this.thePlayer.display();
				
				if (this.points == 20)
				{					
					background(0);
					fill(255);
					text("You Win!", 100, 100);
					text("Press 'C' to continue", 100, 200);
					
					if (this.keepgoing == true)
					{
						this.wins ++;
						setup();
						this.state = 1;
					}
				}
			}
			
		}
		// every time a key is pressed this method will execute
		public void keyPressed()
		{
			// user hit the 'a' key - indicate that we want to move left
			if (key == 'a')
			{
				this.playerMovementDirection = -1;
			}
			
			// user hit the 'd' key - indicate that we want to move right
			if (key == 'd')
			{
				this.playerMovementDirection = 1;
			}
			
			// user hit the 's' key - reload and fire the missile
			if (key == 's')
			{
				this.missile.reload(this.thePlayer.x, this.thePlayer.y);
			}
			if (key =='c')
			{
				this.keepgoing = true;
			}
		}
		
		// every time a key is released this method will execute
		public void keyReleased()
		{
			// indicate that the player should stop moving
			this.playerMovementDirection = 0;
		}
	}
