/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 7: Game of Dice
*/

import java.util.*;
import java.util.Scanner;
public class GameofDice {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean playing = true;
		//array
	    String Dice[][] = new String[6][6];
	    //labels to be checked
	    Dice[0][0] = "Snake eyes";
	    Dice[0][1] = "Australian yo";
	    Dice[0][2] = "Little Joe From Kokomo";
	    Dice[0][3] = "No field five";
	    Dice[0][4] = "Easy six";
	    Dice[0][5] = "Six one you're done";
	    Dice[1][0] = "Ace caught a deuce";
	    Dice[1][1] = "Ballerina";
	    Dice[1][2] = "The fever";
	    Dice[1][3] = "Jimmie Hicks";
	    Dice[1][4] = "Benny Blue";
	    Dice[1][5] = "Easy eight";
	    Dice[2][0] = "Easy four";
	    Dice[2][1] = "OJ";
	    Dice[2][2] = "Brooklyn Forest";
	    Dice[2][3] = "Big Red";
	    Dice[2][4] = "Eight from Decatur";
	    Dice[2][5] = "Nina from Pasadena";
	    Dice[3][0] = "Little Phoebe";
	    Dice[3][1] = "Easy six";
	    Dice[3][2] = "Skinny McKinney";
	    Dice[3][3] = "Square pair";
	    Dice[3][4] = "Railroad nine";
	    Dice[3][5] = "Big one on the end";
	    Dice[4][0] = "Sixie from Dixie";
	    Dice[4][1] = "Skinny Dugan";
	    Dice[4][2] = "Easy eight";
	    Dice[4][3] = "Jesse James";
	    Dice[4][4] = "Puppy paws";
	    Dice[4][5] = "Yo";
	    Dice[5][0] = "The Devil";
	    Dice[5][1] = "Easy eight";
	    Dice[5][2] = "Lou Brown";
	    Dice[5][3] = "Tennessee";
	    Dice[5][4] = "Six five no jive";
	    Dice[5][5] = "Midnight";
	    int max = 6;
        int min = 1;
	    
	    
	    System.out.println("Welcome to the dice throw challange!");
		System.out.println("Do you feel lucky? \"Punk\"... do ya?");
		System.out.println("Press any key and ENTER twice to throw your dice or press (Q or q) and ENTER to chicken your butt off...");
		String play  = input.next();
		//exit before playing
		if(play.equalsIgnoreCase("Q")){
			System.out.println("See ya later alligator!");
			System.exit(0);
		} 
		else {
		
		    do {
		        System.out.println("\nRolling the dice!!");
		        System.out.println();
		        int i = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
				int j = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
		        int comTotal = i + j;
		        System.out.println("You have rolled a " + i + " and " + j + " > the \"" + Dice[i-1][j-1] + "\"");
		    
	            int h = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
				int k = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
	            int playerTotal = h + k;
	            System.out.println("I have rolled a " + h + " and " + k + " > the \"" + Dice[h-1][k-1] + "\"");
	            //computer wins
		        if (comTotal > playerTotal) {
		            System.out.println("I win!!!");
		            System.out.print("Wanna try again?");
		        }
		        //player wins
		        else if (comTotal < playerTotal) {
		            System.out.print("YOU WIN!!! Did you cheat???");
		        }
		        //player wins on double
		        else if (h == k & i != j) {
		            System.out.print("Damn! You win on a Double! What Luck!/n Did you cheat?? Gimme another try, c'mon");
		        }
		        //computer wins on double
		        else if (i == j & h != k) {
		            System.out.print("Damn! I win on a Double! Ah! I pity you fool!/n Wanna try again?");
		        }
		        //tie
		        else if (comTotal == playerTotal) {
		            System.out.print("Stalemate! You're tough, let's try for  a tie breaker");
		        }
		        
		        System.out.println(" Press any key and ENTER to throw your dice  press (Q or q and Enter) to quit");
		        String exit  = input.nextLine();
		        //exit after playing
				if(exit.equalsIgnoreCase("Q")){
					System.out.println("Thanks for being a sport! laters!");
					//no longer playing
					playing = false;
					System.exit(0);
				}
				 
		    }   while (playing = true);
		}
	}
}





