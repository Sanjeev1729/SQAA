public class Device {
    DeviceInputBehavior inputBehavior;
    //Need interface for output and battery
    DeviceType device;

    public Device(DeviceInputBehavior inputBehavior, DeviceType deviceName) {
        this.inputBehavior = inputBehavior;
        this.device = deviceName;
    }
}

public interface DeviceInputBehavior {
    void input();
}

public class TypeInput implements  DeviceInputBehavior {

    @Override
    public void input() {
        System.out.println("I am taking type input");
    }
}

public class VoiceInput implements DeviceInputBehavior {

    @Override
    public void input() {
        System.out.println("I am taking voice input");
    }
}
public enum DeviceType {
    ECHO_SHOW, ECHO_DOT, ECHO
}

public class DeviceFactory {

    public static Device createDevice(DeviceType type) {
        if(type == DeviceType.ECHO) {
            return new Device(new TypeInput(), type);
        } else if(type == DeviceType.ECHO_DOT) {
            return new Device(new VoiceInput(), type);
        }
        //need other if block for echo show
        return null; // or throw exception
    }
}