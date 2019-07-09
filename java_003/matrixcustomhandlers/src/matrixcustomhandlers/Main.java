package matrixcustomhandlers;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;  
import java.io.BufferedWriter;

public class Main {
		
		public static void print2D(String labels[][]) 
	    { 
			String [] colDie = {"Die 1","Die 2","Die 3","Die 4","Die 5","Die 6"};
			String [] rownum = {"Die 1","Die 2","Die 3","Die 4","Die 5","Die 6"};
			
			for (int row = 0; row < rownum.length; row++) {
				System.out.print(String.format("%23s",colDie[row]));
				}
				System.out.println();
				System.out.println();
				//place rows
				for (int row = 0; row < rownum.length; row++) {
					//writeIntoFile.add(line);
		            System.out.print(String.format("%-17s ",rownum[row]));
		            //place label array
		            	for (int col = 0; col < labels[row].length; col++) {
		            		System.out.print(String.format("%-22s ",labels[row][col]));
		            	}
		            //double spacing or they're too close
		            System.out.println("\n");
		            
		            
				}
	    } 
	  
	    public static void main(String args[]) throws IOException 
	    { 
	    	
	    	Scanner input = new Scanner(System.in);
	    	String [][] labels = {{"Snake Eyes", "Australian yo", "Little Joe From Kokomo", "No Field Five", "Easy six", "Six one you're done"}, 
					   {"Ace caught a deuce" , "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
					   {"Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter From Decatur", "Nina from Pasadena"},
					   {"Little Phoebe", "Easy Six", "Skinny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
					   {"Sixie from Dixie", "Skinny Dugan", "Easy Eight", "Jesse James", "Puppy paws", "Yo"},
					   {"The Devil", "Easy Eight", "Lou Brown", "Tennessee", "Six five no jove", "Midnight"}};
	    	String [] colDie = {"Die 1","Die 2","Die 3","Die 4","Die 5","Die 6"};
			String [] rownum = {"Die 1","Die 2","Die 3","Die 4","Die 5","Die 6"};
	    	
	    	System.out.println("How would you like to print the matrix?\n" +
					   "Press the number that corresponds to your option:\n\n" +
					   "1) print on screen only\n" + 
					   "2) print on file\n" + 
					   "3) print on both" +
					   "FOR THIS PROGRAM TO WORK ONLY USE NUMBERS");
	    	
	    	StringBuilder builder = new StringBuilder();
	    	int option  = input.nextInt();
	    	
	    	
	    	/*try {
	    		System.out.println("options " + option);
	    		if (option != ) {
	    	    	throw new InputMismatchException("Wrong Input! I can only take #'s 1-3");
	    		}	
	    	}catch(InputMismatchException e) {
	    		 System.out.println("Exception occurred");
	    	    }
	    	    */
	    	//printing on SCREEN ONLY
	    	try {
		    	if(option == 1){
		    		print2D(labels);
		    		System.out.println("\nProgram Ended");
		    	}
		    	else if(option == 2) {
		    		for (int row = 0; row < rownum.length; row++) {
		    			builder.append(String.format("%23s",colDie[row]));
						}
		    			builder.append("\n\n");
						//place rows
						for (int row = 0; row < rownum.length; row++) {
							builder.append(String.format("%-17s ",rownum[row]));
				            //place label array
				            	for (int col = 0; col < labels[row].length; col++) {
				            		
				            		builder.append(String.format("%-22s ",labels[row][col]));
				            	}
				            //double spacing or they're too close
				            builder.append("\n");
						}
					BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
		    		writer.write(builder.toString());//save the string representation of the board
		    		writer.close();
		    		System.out.println("\nArray was written into txt file.\nProgram Ended");
		    	}
		    	else if(option == 3) {   
		    		print2D(labels);
		    		for (int row = 0; row < rownum.length; row++) {
		    			builder.append(String.format("%23s",colDie[row]));
						}
		    			builder.append("\n\n");
						//place rows
						for (int row = 0; row < rownum.length; row++) {
							builder.append(String.format("%-17s ",rownum[row]));
				            //place label array
				            	for (int col = 0; col < labels[row].length; col++) {
				            		
				            		builder.append(String.format("%-22s ",labels[row][col]));
				            	}
				            //double spacing or they're too close
				            builder.append("\n");
						}
					BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
		    		writer.write(builder.toString());//save the string representation of the board
		    		writer.close();	
		    		System.out.println("\nProgram Ended");
		    	} 
		    	else {
		    	    	throw new InputMismatchException("Wrong Input! I can only take #'s 1-3");
		    	    }
		    	
	    	}catch(InputMismatchException e) {
	    		 System.out.println("Exception occurred");
	    	}
	    	    
	    }
} 
	    