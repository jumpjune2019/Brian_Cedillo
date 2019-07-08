/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 6: Labeling Pair of Dices (Matrix)
*/

import java.util.*;
import java.util.Arrays;
public class LabellingPairofDices {
	public static void main(String[] args) {
		
		String [][] labels = {{"Snake Eyes", "Australian yo", "Little Joe From Kokomo", "No Field Five", "Easy six", "Six one you're done"}, 
							   {"Ace caught a deuce" , "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
							   {"Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter From Decatur", "Nina from Pasadena"},
							   {"Little Phoebe", "Easy Six", "Skinny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
							   {"Sixie from Dixie", "Skinny Dugan", "Easy Eight", "Jesse James", "Puppy paws", "Yo"},
							   {"The Devil", "Easy Eight", "Lou Brown", "Tennessee", "Six five no jove", "Midnight"}};
	    //top
		String [] colDie = {"Die 1","Die 2","Die 3","Die 4","Die 5","Die 6"};
		//left side
		String [] rownum = {"Die 1","Die 2","Die 3","Die 4","Die 5","Die 6"};
		//place top 
		for (int row = 0; row < rownum.length; row++) {
		System.out.print(String.format("%23s",colDie[row]));
		}
		
		System.out.println();
		System.out.println();
		//place rows
		for (int row = 0; row < rownum.length; row++) {
            System.out.print(String.format("%-17s ",rownum[row]));
            //place label array
            	for (int col = 0; col < labels[row].length; col++) {
            		System.out.print(String.format("%-22s ",labels[row][col]));
            	}
            //double spacing or they're too close
            System.out.println("\n");
		}
	}
}
	
