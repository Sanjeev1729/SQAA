package alexa;

public class Battery {

	private Integer batteryPercentage = 56;
	public BatteryStatus getBatteryStatus() {
		if(batteryPercentage <= 40)
			return BatteryStatus.plugin_charger;
		if(batteryPercentage > 40 && batteryPercentage < 85)
			return BatteryStatus.semiCharged;
		if(batteryPercentage > 85)
			return BatteryStatus.full;
		return null;
	}
}
