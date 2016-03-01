/* Author:  Jeremiah Crowley
   Date:    11/28/2012
   Section: CS101, Section 02, Fall 2012
*/

package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class PurpleAlien extends Alien
{
	// purple aliens get their own graphic
	PImage graphic;
			
	public PurpleAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
				
		// load in the alien1.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("alien3.jpg");
	}
		
	@Override
	public void move()
	{
		// only update our x position based on our direction
		this.x += this.direction;

		// if we hit the right edge we should turn around
		// and move down by one row
		if (this.x > this.canvas.width)
		{
			this.direction *= -1;
			this.graphic = this.canvas.loadImage("pacman.jpg");
			this.x = this.canvas.width;
			this.y += size;
		}
		
		// if we hit the left edge we should turn around
		// and move down by one row
		if (this.x < 0 - this.size)
		{
			this.direction *= -1;
			this.graphic = this.canvas.loadImage("alien3.jpg");
			this.x = 0 - this.size;
			this.y += size;
		}
	}
	// override the superclass display method
	@Override
	public void display()
	{
		// only draw if we are alive
		if (this.alive)
		{
		// image the graphic to the screen
		canvas.image(this.graphic, this.x ,this.y, this.size, this.size);
		}
	}
}
