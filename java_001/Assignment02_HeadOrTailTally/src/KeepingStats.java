/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 2: Keeping Stats
*/

import java.util.*;

public class KeepingStats {
	
	public static void main(String[] args) {
  	
	int heads = 1;
  	int tails = 2;
  	int[] tally = new int[]{0, 0};
  	
  	//iterate 1000 times
  	for(int x = 0; x < 1000; x++) {
  		int toss = (int)Math.floor((Math.random() * ((tails - heads) + 1)) + heads);
  		if(toss == heads){
  			tally[0] += 1;
      }
  	else if (toss == tails){ //tallying up
  		tally[1] += 1;
      }
  	}
  	
  	System.out.println("1000 Coin Flips");
  	System.out.println("Count of Head: " + tally[0]);
  	System.out.println("Count of Tail: " + tally[1]);
  	
  	//testing output
  	//System.out.print("Tally total = ");
  	//System.out.println(tally[0] + tally[1]);
  }
}