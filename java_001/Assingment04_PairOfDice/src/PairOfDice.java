/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 4: Pair of Dice anyone?
*/

import java.util.*;

public class PairOfDice {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int max = 6;
		int min = 1;
		
		System.out.println("Press any key to throw a pair of dice and press Enter (or Q and Enter to quit)");
		String play  = input.next();
		if(play.equals("Q")){
			System.exit(0);
		} 
		else {
			do {
				//rolling a pair of dice
				int x = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
				int y = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
				System.out.println("You have rolled the following: ");
				System.out.println("First Die: " + x);
				System.out.println("Second Die: " + y);
				System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit");
			} while(input.next().equalsIgnoreCase("y"));
	        input.close();
		}
	}
}
