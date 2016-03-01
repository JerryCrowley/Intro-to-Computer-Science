/* Author:  Jeremiah Crowley
   Date:    11/28/2012
   Section: CS101, Section 02, Fall 2012
*/

package spaceinvaders;

import processing.core.PApplet;

public class AlienMissile 
{
	// store our current position on the screen
	public int x;
	public int y;
		
	// store a reference to our graphical canvas
	public PApplet canvas;

	// constructor
	public AlienMissile(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
	}

	// missiles consistently downward towards the bottom of the screen
	public void move()
	{
		this.y += 5;
	}
			
	// draw the missile on the screen
	public void display()
	{
		this.canvas.fill(225);
		this.canvas.rect(x,y,5,25);
	}
			
	// "reload" the missile - essentially place it on top of the player
	// and trigger the sound effect
	public void reload(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

}
