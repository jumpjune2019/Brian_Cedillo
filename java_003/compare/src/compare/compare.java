package compare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class compare {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader reader1 = new BufferedReader(new FileReader("/Users/briancedillo/java_training/assignments/java_003/compare/src/compare/file.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("/Users/briancedillo/java_training/assignments/java_003/compare/src/compare/file2.txt"));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        int characterCount1 = 0;
        int characterCount2 = 0;
        int bothCharCount = 0;
        boolean areEqual = true;
         
        while (line1 != null || line2 != null) {
            if(!(line1.equals(""))) { 
                characterCount1 += line1.length();
            }
            if(!(line2.equals(""))) { 	
                characterCount2 += line2.length();
            }
            
            if(line1 == null || line2 == null) {
                areEqual = false;  
                break;
            }
            else if(! line1.equalsIgnoreCase(line2)) {
                areEqual = false;
                break;
            }
            bothCharCount = characterCount1 + characterCount2;
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }
         
        if(areEqual) {
        	System.out.println("Output: file.txt and file2.txt: ");
            System.out.println("Identical Content");
            System.out.println("Character length for both: " + bothCharCount);
            
        }
        else {
            System.out.println("Different Content.");
            System.out.println("Character length for file.txt: " + characterCount1);
            System.out.println("Character length for file2.txt: " + characterCount2);
        }
        reader1.close();
        reader2.close();
    }

}	
