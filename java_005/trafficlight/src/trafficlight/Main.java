/*
* Traffic Light Simulator
* Threads and enum practice
* 
* PROCEED TO RUN AFTER ERRORS FOR THIS VERSION RUNS AFTER IGNORING 
* 
* *Kill program on ENTER*
* 
* @author Brian Cedillo
*/

package trafficlight;

import java.util.Scanner;

public class Main {
    synchronized static void RunLights() {
    	//error occurring during launch?
    	ThreadControl lights= new ThreadControl("");
        
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();

        //loop as long as there is an empty space/ENTER is pressed
        while(readString.equals("")) {
            if (readString.isEmpty()) {
            	lights.myStop();
            	System.out.println("Traffic Light Simulator is Done!");
                //sometimes threads are closed 1 or 2 (thread) passes AFTER 
                break;
            }
            if (scanner.hasNextLine()) {
                readString = scanner.nextLine();
            }
            else {
                readString = null;
            }
            scanner.close();
        }
    }
    public static void main(String[] args) {
        RunLights();
    }
}