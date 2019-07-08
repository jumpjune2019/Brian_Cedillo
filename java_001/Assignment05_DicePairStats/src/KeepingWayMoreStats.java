/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 5: Keeping Way More Stats
*/

import java.util.*;
import java.util.Arrays;
import java.util.Collections; 

public class KeepingWayMoreStats {
	public static void main(String[] args) {
		
		
		int max = 6;
		int min = 1;
		
		Integer[] diceArray = {0, 0};
		
		int group1 = 0;
		int group2 = 0;
		int group3 = 0;
		int group4 = 0;
		int group5 = 0;
		int group6 = 0;
		int group7 = 0;
		int group8 = 0;
		int group9 = 0;
		int group10 = 0;
		int group11 = 0;
		int group12 = 0;
		int group13 = 0;
		int group14 = 0;
		int group15 = 0;
		int group16 = 0;
		int group17 = 0;
		int group18 = 0;
		int group19 = 0;
		int group20 = 0;
		int group21 = 0;
		
		for(int z = 0; z < 1000; z++) {
			//die arrays
			diceArray[0] = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
			diceArray[1] = (int)Math.floor((Math.random() * ((max - min) + 1)) + min);
			
			//sort
			Arrays.sort(diceArray, Collections.reverseOrder());
			//counters
			if (diceArray[0] == 1 & diceArray[1] == 1) {
				group1 += 1;
			}
			else if ((diceArray[0] == 2) && (diceArray[1] == 1)) {
				group2 += 1;
			}
			else if (diceArray[0] == 2 & diceArray[1] == 2) {
				group3 += 1;
			}
			else if (diceArray[0] == 3 & diceArray[1] == 1) {
				group4 += 1;
			}
			else if (diceArray[0] == 3 & diceArray[1] == 2) {
				group5 += 1;
			}
			else if (diceArray[0] == 3 & diceArray[1] == 3) {
				group6 += 1;
			}
			else if (diceArray[0] == 4 & diceArray[1] == 1) {
				group7 += 1;
			}
			else if (diceArray[0] == 4 & diceArray[1] == 2) {
				group8 += 1;
			}
			else if (diceArray[0] == 4 & diceArray[1] == 3) {
				group9 += 1;
			}
			else if (diceArray[0] == 4 & diceArray[1] == 4) {
				group10 += 1;
			}
			else if (diceArray[0] == 5 & diceArray[1] == 1) {
				group11 += 1;
			}
			else if (diceArray[0] == 5 & diceArray[1] == 2) {
				group12 += 1;
			}
			else if (diceArray[0] == 5 & diceArray[1] == 3) {
				group13 += 1;
			}
			else if (diceArray[0] == 5 & diceArray[1] == 4) {
				group14 += 1;
			}
			else if (diceArray[0] == 5 & diceArray[1] == 5) {
				group15 += 1;
			}
			else if (diceArray[0] == 6 & diceArray[1] == 1) {
				group16 += 1;
			}
			else if (diceArray[0] == 6 & diceArray[1] == 2) {
				group17 += 1;
			}
			else if (diceArray[0] == 6 & diceArray[1] == 3) {
				group18 += 1;
			}
			else if (diceArray[0] == 6 & diceArray[1] == 4) {
				group19 += 1;
			}
			else if (diceArray[0] == 6 & diceArray[1] == 5) {
				group20 += 1;
			}
			else if ((diceArray[0] == 6) & (diceArray[1] == 6)) {
				group21 += 1;
			}
		}	
		
		/*
		 * check roll count
		  int count = group1 + group2 + group3 + group4 + group5 + group6 + 
					  group7 + group8 + group9 + group10 + group11 + group12 +
					  group13 + group14 + group15 + group16 + group17 + group18 +
					  group19 + group20 + group21;
		*/
		
		//output
		System.out.println("100 Random 2 dice toss stats");
		System.out.println("Dice 1 and dice 1: " + group1 + " times");
		System.out.println("Dice 2 and dice 1: " + group2 + " times");
		System.out.println("Dice 2 and dice 2: " + group3 + " times");
		System.out.println("Dice 3 and dice 1: " + group4 + " times");
		System.out.println("Dice 3 and dice 2: " + group5 + " times");
		System.out.println("Dice 3 and dice 3: " + group6 + " times");
		System.out.println("Dice 4 and dice 1: " + group7 + " times");
		System.out.println("Dice 4 and dice 2: " + group8 + " times");
		System.out.println("Dice 4 and dice 3: " + group9 + " times");
		System.out.println("Dice 4 and dice 4: " + group10 + " times");
		System.out.println("Dice 5 and dice 1: " + group11 + " times");
		System.out.println("Dice 5 and dice 2: " + group12 + " times");
		System.out.println("Dice 5 and dice 3: " + group13 + " times");
		System.out.println("Dice 5 and dice 4: " + group14 + " times");
		System.out.println("Dice 5 and dice 5: " + group15 + " times");
		System.out.println("Dice 6 and dice 1: " + group16 + " times");
		System.out.println("Dice 6 and dice 2: " + group17 + " times");
		System.out.println("Dice 6 and dice 3: " + group18 + " times");
		System.out.println("Dice 6 and dice 4: " + group19 + " times");
		System.out.println("Dice 6 and dice 5: " + group20 + " times");
		System.out.println("Dice 6 and dice 6: " + group21 + " times");	
		
		//System.out.println(count);	
	}
}