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
        boolean areEqual = true;
         
        while (line1 != null || line2 != null) {
            if(line1 == null || line2 == null) {
                areEqual = false;  
                break;
            }
            else if(! line1.equalsIgnoreCase(line2)) {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }
         
        if(areEqual) {
            System.out.println("Identical Content");
        }
        else {
            System.out.println("Different Content.");
        }
        reader1.close();
        reader2.close();
    }

}	
