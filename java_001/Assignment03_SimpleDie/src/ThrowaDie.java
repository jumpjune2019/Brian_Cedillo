/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 3: Throw a die
*/

import java.util.*;

public class ThrowaDie {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		int max = 6;
		int min = 1;
		
		System.out.println("Press any key to throw a die and press Enter (or Q and Enter to quit)");
		String play  = input.next();
		if(play.equals("Q")){
			System.exit(0); //exit
		} 
		else {
			do {
				//rolling a single die
				int dice = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
				System.out.println("You have rolled a " + dice);
				System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit");
			} while(input.next().equalsIgnoreCase("y"));
	        input.close();
		}
	}
}