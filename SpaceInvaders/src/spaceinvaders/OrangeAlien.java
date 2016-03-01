/* Author:  Jeremiah Crowley
   Date:    11/28/2012
   Section: CS101, Section 02, Fall 2012
*/

package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class OrangeAlien extends Alien
{
	// orange aliens get their own graphic
	PImage graphic;
			
	public OrangeAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
				
		// load in the alien1.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("alien4.jpg");
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
