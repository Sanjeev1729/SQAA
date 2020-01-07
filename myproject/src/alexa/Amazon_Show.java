package alexa;

import java.util.ArrayList;

public class Amazon_Show implements Devices{

	Battery batteryStatus;
	@Override
	public ArrayList<String> getInput(DeviceType deviceType) {
		ArrayList<String> input = new ArrayList<String>();
		if(deviceType.equals(DeviceType.amazon_show)) {
			input.add("voice");
			input.add("type");
			input.add("touch");
		}
		if(deviceType.equals(DeviceType.amazon_echo)) {
			input.add("voice");
		}
		if(deviceType.equals(DeviceType.amazon_dot)) {
			input.add("touch");
			input.add("type");
		}
		return input;
	}

	@Override
	public ArrayList<String> getOutput(DeviceType deviceType) {
		ArrayList<String> output = new ArrayList<String>();
		if(deviceType.equals(DeviceType.amazon_show)) {
			output.add("voice");
			output.add("display");
		}
		if(deviceType.equals(DeviceType.amazon_echo)) {
			output.add("voice");
		}
		if(deviceType.equals(DeviceType.amazon_dot)) {
			output.add("voice");
			output.add("display");
		}
		return output;
	}

	@Override
	public BatteryStatus getBatteryStatus() {
		batteryStatus = new Battery();
		return batteryStatus.getBatteryStatus();
		
	}

}

	