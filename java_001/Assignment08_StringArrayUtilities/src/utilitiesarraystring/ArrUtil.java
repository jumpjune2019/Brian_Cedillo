package utilitiesarraystring;
/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 8: String Array Utilities
*/
import java.util.*;
public class ArrUtil {
	public static void main(String[] args) {
		
		
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		
		System.out.println("This is the a test of the arrayHasExactMatch "
							+ "and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items");
		
		System.out.println(" {\"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\"}");
		
		//check array
		//System.out.println(Arrays.toString(myList));
		
		
		
		StringArrayUtilities link = new StringArrayUtilities();
		System.out.print("Scenario 1 \narrayHasExactMatch (myList, \"zo\", false) : is ");
		//found will be false
		link.arrayHasExactMatch(myList, "zo", false);
		System.out.println();
		
		System.out.print("Scenario 2 \narrayHasExactMatch (myList, \"zoo\", false) : is ");
		//found will be true
		link.arrayHasExactMatch (myList, "zoo", false);
		System.out.println();
		
		System.out.print("Scenario 3 \narrayHasExactMatch (myList, \"zoo\", true) : is ");
		//found will be false
		link.arrayHasExactMatch (myList, "zoo", true);
		System.out.println();
		
		System.out.print("Scenario 4 \narrayHasExactMatch (myList, \"foobar\", true) : is ");
		//found will be false
		link.arrayHasExactMatch (myList, "foobar", true);
		System.out.println();
		
		System.out.print("Scenario 5 \narrayHasExactMatch (myList, \"foobar\", false) : is ");
		//found will be true
		link.arrayHasExactMatch (myList, "foobar", false);
		System.out.println();
		
		System.out.print("Scenario 6 \narrayHasExactMatch (myList, \"delta\", true) : is ");
		//found will be false
		link.arrayHasExactMatch (myList, "delta", true);
		System.out.println();
		
		System.out.print("Scenario 7 \narrayHasExactMatch (myList, \"Delta\", true) : is ");
		//found will be true
		link.arrayHasExactMatch (myList, "Delta", true);
		System.out.println();
		
		System.out.print("Scenario 8 \nindexofOccuranceInArray (myList, \"zo\", false) returns ");
		//foundIndexes will contain [-1]
		link.indexOfOccuranceInArray (myList, "zo", false);
		System.out.println();
		
		System.out.print("Scenario 9 \nindexofOccuranceInArray (myList, \"zoo\", false) returns ");
		//foundIndexes will contain [5]
		link.indexOfOccuranceInArray (myList, "zoo", false);
		System.out.println();
		
		System.out.print("Scenario 10 \nindexofOccuranceInArray (myList, \"zoo\", true) returns ");
		//foundIndexes will contain [-1]
		link.indexOfOccuranceInArray (myList, "zoo", true);
		System.out.println();
		
		System.out.print("Scenario 11 \nindexofOccuranceInArray (myList, \"foobar\", true) returns ");
		//foundIndexes will contain [-1]
		link.indexOfOccuranceInArray (myList, "foobar", true);
		System.out.println();
		
		System.out.print("Scenario 12 \nindexofOccuranceInArray (myList, \"foobar\", false) returns ");
		//foundIndexes will contain [1]
		link.indexOfOccuranceInArray (myList, "foobar", false);
		System.out.println();
		
		System.out.print("Scenario 13 \nindexofOccuranceInArray (myList, \"delta\", true) returns ");
		//foundIndexes will contain [-1]
		link.indexOfOccuranceInArray (myList, "delta", true);
		System.out.println();
		
		System.out.print("Scenario 14 \nindexofOccuranceInArray (myList, \"Delta\", true) returns ");
		//foundIndexes will contain [2]
		link.indexOfOccuranceInArray (myList, "Delta", true);

	}

}
