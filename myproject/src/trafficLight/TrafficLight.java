package trafficLight;

public class TrafficLight extends TrafficSignal {
    public String getMessage() {
    	switch(state) {
    	  case STOP : return "red";
    	  case CAUTION : return "Yellow";
    	  case GO : return "Green";	  
    	}
    	return "";
    }
}
