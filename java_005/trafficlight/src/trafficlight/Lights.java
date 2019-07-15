package trafficlight;

enum Lights {
    GREEN(5000, "Light is Green - Go!"), YELLOW(2000, "Light is Yellow - Beware!"), RED(3000, "Light is Red - Stop!"); 
	
    private Integer time;
    private String label;
    
    Lights(Integer t, String myStr) {
        time = t;
        label = myStr;
    }
    
    int getTime() {
        return time;
    }
    private int current;
    
    String getString() {
    	return label;
    	
    }
    
    synchronized Lights getNext() {
	    current++;
		if(current >= 3) {
			current = 0; 
		}
		
		return values()[current];
    }
}

