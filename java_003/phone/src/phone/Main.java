package phone;

import java.util.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void ar(String data) throws Ex {
    	if (data.isEmpty()) {
    		throw new Ex();
    	}
    }
	
	 public static void main(String args[]) throws IOException, Ex { 
		 
		 String [][] array = new String[5][3];
		 Scanner input = new Scanner(System.in);
		 String data = "";
		 
		 System.out.println("Creating Phonebook.");
		 boolean yes = false;
		 for( int x = 0; x < array.length; x++) {
			 for( int y = 0; y < 3; y++) {
					do{
						try{
	                    	System.out.println("Enter name: ");
		                    data = input.nextLine();
		                    ar(data);
		                    if(!data.isEmpty()){
		                    yes = true;
		                    array[x][y] = data;
		                    }
	                    }catch (Exception e){
        		    	System.out.println("Input Needed");
	                    }
					}while(yes = false);
					 System.out.println(y); 
					 
					 do{
		                try{
	                    	System.out.println("Enter Phone Number: ");
		                    data = input.nextLine();
		                    ar(data);
		                    array[x][y] = data;
		                    }catch (Exception e){
		        		    	System.out.println("Input Needed");
		        		 }
		                	System.out.println(y);
		                }while(yes = false);
		                
		                do{
		                	try{
		                    	System.out.println("Input Needed");
			                    data = input.nextLine();
			                    ar(data);
			                    array[x][y] = data;
			                    
		                    }
		                	catch (Exception e){
		        		    	System.out.println("Exception found: " + e);
		        		 }	
	         }while(yes = false); 
		    
		}
			 }
		 	
		 	
	         
	        input.close();
	        
	        System.out.println("Creating Phonebook from Input.\n");
	        
	        printToScreen(array);
	        printToFile(array);
	    }

	    static void printToScreen(String[][] array) {
	        String[] label = new String[]{"Name", "Phone Number", "City" }; 
	        for(int x = 0; x< label.length; x++) {;
	        	System.out.print(String.format("%-17s", label[x]));
	        }
	        System.out.println();
	        
	        for(int x=0;x<array.length;x++) {
	            for(int y=0;y<array[x].length;y++) {
	                System.out.print(String.format("%-16s ",array[x][y]));
	            }
	            System.out.println();
	        }
	        
	    }

	    static void printToFile(String[][] book) {
	    	String[] label = new String[]{"Name", "Phone Number", "City" };
	        try {
	
	            BufferedWriter out = new BufferedWriter(new FileWriter("src/phone/phone.txt"));
	            
	            for(int x = 0; x< label.length; x++) {
	            out.write(String.format("%-17s", label[x]));
	            }
	            out.write("\n");
	            for(int x=0;x<book.length;x++) {
	                for(int y=0;y<book[x].length;y++) {
	                    out.write(String.format("%-16s ", book[x][y]));
	                }
	                out.write("\n");
	            }
	            
	            out.close();
	          }
	          catch (IOException e) {
	          }
	 }
}