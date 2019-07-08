package utilitiesarraystring;
/* Author: Brian Cedillo
Date: July 2019
Description: Assignment 8: String Array Utilities
*/
public class StringArrayUtilities {
	public void arrayHasExactMatch(String[] array, String str, boolean caseSensitive) {
		boolean state = false;
		String[] lowerCasedArray = new String[array.length];
		if(caseSensitive) {
			state = this.findInArray(array, str);
		}else {
			
			for(int x = 0; x<array.length; x++) {
				String s = array[x].toLowerCase();
				lowerCasedArray[x]= s;
			}
			str.toLowerCase();
			state = this.findInArray(lowerCasedArray, str);
		}
		System.out.println(state);
		return;
	}
	
	private boolean findInArray(String[] array, String s) {
		for(int x = 0; x<array.length; x++) {
			//check that it works
			//System.out.println(array[x]);
			//System.out.println(s);
			if(array[x].equals(s)) {
				return true;
			}
		}
		return false;
		
	}


	public void indexOfOccuranceInArray(String[] myList, String string, boolean b) {
		
		int position;
		String[] lowerCasedArray = new String[myList.length];
		if(b) {
			position = this.findIndexValue(myList, string);
		}else {
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
