package trafficLight;

public abstract class TrafficSignal {

	public static final int GO = 0;
	public static final int CAUTION = 1;
	public static final int STOP = 2;
	public static final int NUMBER_OF_STATES = 3;
	
	boolean passageRequested = false;
	int state = STOP;
	
	public boolean getPassageRequested() {
		return passageRequested;
	}
	
	public boolean requestPassage() {
		if(state==STOP) {
			passageRequested = true;
		}
		return false;
	}
	
	public void changeState() {
		this.state = (state + 1) % NUMBER_OF_STATES;
		if(state==GO)
			passageRequested = false;
	}
	
	public int getState() {
		return state;
	}
	
	public abstract String getMessage();
	
}
