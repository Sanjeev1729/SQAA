package alexa;

import java.util.ArrayList;

public interface Devices {
   	
	abstract ArrayList<String> getInput(DeviceType deviceType);
	
	abstract ArrayList<String> getOutput(DeviceType deviceType);
	
	abstract BatteryStatus getBatteryStatus();
	
}
