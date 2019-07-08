  /* Author: Brian Cedillo
  Date: July 2019
  Description: Assignment 1: Head or Tail
  */
  
import java.util.*;

public class HeadorTail { 
	
  public static void main(String[] args){
  	int heads = 1;
  	int tails = 2;
  	//random flip of 1 or 2 - floor rounds down
  	int toss = (int)Math.floor((Math.random() * ((tails - heads) + 1)) + heads);
  			
  	if(toss == heads){
	        System.out.println("Coin FLip Program");
	        System.out.println("The Coin FLip is: Head");
      }
  	else if (toss == tails){
	        System.out.println("Coin FLip Program");
	        System.out.println("The Coin FLip is: Tail");
      }
  	//testing output
  	//System.out.println(toss);
  }
}