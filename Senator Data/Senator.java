/* Author:  Jeremiah Crowley
   Date:    12/10/2012
   Section: CS101, Section 02, Fall 2012
*/

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class Senator
{
	
	static String abbrev; 
	static String state;

	public static void main(String[] args) throws IOException
	{
		//Create a scanner
		Scanner input1 = new Scanner(System.in);
			
		breakTheWholeWhileLoop:
		while(true)
		{
			// define our URL
			URL serviceURL = new URL("http://i5.nyu.edu/~cmk380/cs101/USStates.txt");
					
			// connect and obtain data from this URL
			Scanner input = new Scanner( serviceURL.openStream() );
			
			//Ask for state
		    System.out.print("Enter state (abbreviation): ");
		    String stateAbbreviation = input1.next();
		        	        
			// read in our data
			while ( input.hasNext() )
			{
				// grab a line
				String data = input.nextLine();
			
				// split up the line based on the position of the commas
				String[] splitData = data.split(",");
						
				// grab out the abbreviation
				String abbreviation = splitData[1];  
	
				if(stateAbbreviation.equals(abbreviation))
				{
					state = splitData[0];
					abbrev = stateAbbreviation;
					input.close();
					
					//Break whole loop
					break breakTheWholeWhileLoop;
				}
			}
			
		}
		
		double numLines = 0;	
				
		// define our URL
		URL senatorURL = new URL("http://www.contactingthecongress.org/downloads/ContactingCongress.db.txt");
						
		// connect and obtain data from this URL
		Scanner input2 = new Scanner( senatorURL.openStream() );
			
		// read in our data
		while ( input2.hasNext() )
		{
			// grab a line
			String data = input2.nextLine();
			
			if (numLines != 0)
			{
				// split up the line based on the position of the commas
				String[] splitData = data.split("\t");
				

				if(splitData[0].equals(abbrev+"SR"))
				{
					System.out.println("");
					System.out.println("State: " + state);
					System.out.println("");
					System.out.println("Senior Senator");
					System.out.println("Name: " + splitData[1]);
					
					//Try catch their information (exception raised if not found)
					try
					{
						System.out.println("DC Office: " + splitData[3]);
					}
					catch (Exception e)
					{
						System.out.println("Addrress unavailable.");
					}
					
					try
					{
						System.out.println("DC Voice: " + splitData[4]);
					}
					catch (Exception e)
					{
						System.out.println("Phone unavailable.");
					}
					
					try
					{
						System.out.println("District Voice: " + splitData[5]);
					}
					catch (Exception e)
					{
						System.out.println("Phone unavailable.");
					}
					
					try
					{
						System.out.println("Website: " + splitData[7]);
					}
					catch (Exception e)
					{
						System.out.println("Website unavailable.");
					}
					System.out.println("");
				}
				
				
				if(splitData[0].equals(abbrev+"JR"))
				{
					System.out.println("Junior Senator");
					System.out.println("Name: " + splitData[1]);
					
					//Try catch their information (exception raised if not found)
					try
					{
						System.out.println("Address: " + splitData[3]);
					}
					catch (Exception e)
					{
						System.out.println("Addrress unavailable.");
					}
					
					try
					{
						System.out.println("DC Voice: " + splitData[4]);
					}
					catch (Exception e)
					{
						System.out.println("Phone unavailable.");
					}
					
					try
					{
						System.out.println("District Voice: " + splitData[5]);
					}
					catch (Exception e)
					{
						System.out.println("Phone unavailable.");
					}
					
					try
					{
						System.out.println("Website: " + splitData[7]);
					}
					catch (Exception e)
					{
						System.out.println("Website unavailable.");
					}
					System.out.println("");
				}
							
			}
			
			numLines ++; 
		}
				
		// close our URL
		input2.close();

	}
}

	

