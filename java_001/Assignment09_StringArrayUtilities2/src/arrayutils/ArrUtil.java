package arrayutils;
/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 9: String Array Utilities Part 2
*/
public class ArrUtil {
	
	
	static boolean arrayHasExactMatch(String arrayList[], String methodList, boolean find){
	       boolean point = false;
	       for(int index = 0; index < arrayList.length; index++){
	           if(find  == true){
	               if(arrayList[index].equals(methodList)) {
	                   point = true;
	               }
	           }
	           else{
	               if(arrayList[index].equalsIgnoreCase(methodList)){
	                   point = true;
	               }
	           }
	       }
	       return point;
	   }

	private boolean findInArray(String arrayList[], String methodList) {
		for(int x = 0; x<arrayList.length; x++) {
			//check that it works
			//System.out.println(array[x]);
			//System.out.println(methodList);
			if(arrayList[x].equals(methodList)) {
				return true;
			}
		}
		return false;
		
	}


	static void indexOfOccuranceInArray(String[] myList, String string, boolean b) {
		
		int position;
		String[] lowerCasedArray = new String[myList.length];
		if(b) {
			position = this.findIndexValue(myList, string);
		}
		else {
			for(int x = 0; x<myList.length; x++) {
				String s = myList[x].toLowerCase();
				lowerCasedArray[x]= s;
			}
			string.toLowerCase();
			position = this.findIndexValue(lowerCasedArray, string);
		}
		System.out.println(position);
	}
	private int findIndexValue(String[] myList, String string) {
		
		for (int x = 0; x < myList.length;x++) {
			//check that it works
			//System.out.println(myList[x]);
			//System.out.println(string);
			if(myList[x].equals(string)) {
				return x;
			}
		}
		
		return -1;
	}

}