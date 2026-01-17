import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Device {
    private boolean poweredOn;
    private final String name;

    protected Device(String name) {
        this.name = name;
        this.poweredOn = false;
    }

    // Encapsulation for power
    public boolean isPoweredOn() {
        return poweredOn;
    }

    public void setPoweredOn(boolean poweredOn) {
        this.poweredOn = poweredOn;
        // Always show device-specific status when power state changes
        if (this.poweredOn) {
            System.out.println(name + " turned ON.");
            showStatus(); // device-specific status
        } else {
            System.out.println(name + " turned OFF.");
        }
    }

    public String getName() {
        return name;
    }

    public abstract void showStatus();

    public static void setPowerForAll(List<Device> devices, boolean power) {
        if (devices == null) return;
        for (Device d : devices) {
            d.setPoweredOn(power);
        }
    }

    public static int countPoweredOnDevices(List<Device> devices) {
        if (devices == null) return 0;
        int count = 0;
        for (Device d : devices) if (d.isPoweredOn()) count++;
        return count;
    }
}

/** Air Conditioner */
class AirConditioner extends Device {
    private int fanSpeed;     // e.g., 1..5
    private int temperature;  // degrees Celsius

    public AirConditioner() {
        this("AirConditioner", 3, 24); // default values
    }

    public AirConditioner(String name, int fanSpeed, int temperature) {
        super(name);
        this.fanSpeed = fanSpeed;
        this.temperature = temperature;
    }

    // Encapsulation
    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
        System.out.println(getName() + " fan speed set to " + fanSpeed + ".");
        showStatus();
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(getName() + " temperature set to " + temperature + "°C.");
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isPoweredOn()) {
            System.out.printf("%s STATUS -> power: ON | fan speed: %d | temperature: %d°C%n",
                    getName(), fanSpeed, temperature);
        } else {
            System.out.printf("%s STATUS -> power: OFF%n", getName());
        }
    }
}

/** Lamp Shade */
class LampShade extends Device {
    private int brightnessPercent; // 0..100
    private String color;          // e.g., "yellow", "white"

    public LampShade(int brightnessPercent, String color) {
        super("LampShade");
        this.brightnessPercent = clampPercent(brightnessPercent);
        this.color = Objects.requireNonNull(color);
    }

    // Copy constructor
    public LampShade(LampShade other) {
        super("LampShade");
        this.brightnessPercent = other.brightnessPercent;
        this.color = other.color;
    }

    private int clampPercent(int p) {
        if (p < 0) return 0;
        if (p > 100) return 100;
        return p;
    }

    public int getBrightnessPercent() {
        return brightnessPercent;
    }

    public void setBrightnessPercent(int brightnessPercent) {
        this.brightnessPercent = clampPercent(brightnessPercent);
        System.out.println(getName() + " brightness set to " + this.brightnessPercent + "%.");
        showStatus();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = Objects.requireNonNull(color);
        System.out.println(getName() + " color set to " + this.color + ".");
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isPoweredOn()) {
            System.out.printf("%s STATUS -> power: ON | brightness: %d%% | color: %s%n",
                    getName(), brightnessPercent, color);
        } else {
            System.out.printf("%s STATUS -> power: OFF%n", getName());
        }
    }
}

/** Television */
class Television extends Device {
    private int channel;           // 1,2,...
    private int volumePercent;     // 0..100

    public Television(int channel, int volumePercent) {
        super("Television");
        this.channel = Math.max(1, channel);
        this.volumePercent = clampPercent(volumePercent);
    }

    private int clampPercent(int p) {
        if (p < 0) return 0;
        if (p > 100) return 100;
        return p;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = Math.max(1, channel);
        System.out.println(getName() + " channel set to " + this.channel + ".");
        showStatus();
    }

    public int getVolumePercent() {
        return volumePercent;
    }

    public void setVolumePercent(int volumePercent) {
        this.volumePercent = clampPercent(volumePercent);
        System.out.println(getName() + " volume set to " + this.volumePercent + "%.");
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isPoweredOn()) {
            System.out.printf("%s STATUS -> power: ON | channel: %d | volume: %d%%%n",
                    getName(), channel, volumePercent);
        } else {
            System.out.printf("%s STATUS -> power: OFF%n", getName());
        }
    }
}

/** Microwave Oven */
class MicrowaveOven extends Device {
    private int timerSeconds;     // countdown seconds
    private int temperatureC;     // degrees Celsius or power level representation

    public MicrowaveOven() {
        this("MicrowaveOven", 0, 180); // default timer 0s, temp 180°C
    }

    public MicrowaveOven(String name, int timerSeconds, int temperatureC) {
        super(name);
        this.timerSeconds = Math.max(0, timerSeconds);
        this.temperatureC = temperatureC;
    }

    public int getTimerSeconds() {
        return timerSeconds;
    }

    public void setTimerSeconds(int timerSeconds) {
        this.timerSeconds = Math.max(0, timerSeconds);
        System.out.println(getName() + " timer set to " + this.timerSeconds + " seconds.");
        showStatus();
    }

    public int getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(int temperatureC) {
        this.temperatureC = temperatureC;
        System.out.println(getName() + " temperature set to " + this.temperatureC + "°C.");
        showStatus();
    }

    @Override
    public void showStatus() {
        if (isPoweredOn()) {
            System.out.printf("%s STATUS -> power: ON | timer: %d s | temperature: %d°C%n",
                    getName(), timerSeconds, temperatureC);
        } else {
            System.out.printf("%s STATUS -> power: OFF%n", getName());
        }
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        // a.i. Air conditioner at default values (fan speed = 3, temperature = 24)
        AirConditioner ac = new AirConditioner("AirConditioner-LivingRoom", 3, 24);

        // a.ii Two lamp shades:
        // One constructed with 100% brightness and yellow light.
        LampShade lamp1 = new LampShade(100, "yellow");
        // Other constructed by copying the first lamp.
        LampShade lamp2 = new LampShade(lamp1);

        // a.iii Television with channel = 1, volume 10%
        Television tv = new Television(1, 10);

        // a.iv Microwave at default values
        MicrowaveOven microwave = new MicrowaveOven("Microwave-Kitchen", 0, 180);

        // Put them in a List<Device> to show polymorphic storage
        List<Device> devices = new ArrayList<>();
        devices.add(ac);
        devices.add(lamp1);
        devices.add(lamp2);
        devices.add(tv);
        devices.add(microwave);

        // Demonstration: Use the static device-level function to turn all devices ON
        System.out.println(">>> Turning ALL devices ON via Device.setPowerForAll(...)");
        Device.setPowerForAll(devices, true);

        // Check how many are ON
        int countOn = Device.countPoweredOnDevices(devices);
        System.out.println("Number of devices powered ON: " + countOn);

        // Make some changes through setters (each setter prints status after change)
        System.out.println("\n>>> Changing some attributes to demonstrate encapsulation & setters:");
        ac.setFanSpeed(4);
        ac.setTemperature(22);

        lamp1.setBrightnessPercent(75);
        lamp2.setColor("warm white");

        tv.setChannel(5);
        tv.setVolumePercent(30);

        microwave.setTimerSeconds(120); // 2 minutes
        microwave.setTemperatureC(200);

        // Turn OFF only lamps using the static function on a sublist
        System.out.println("\n>>> Turning OFF just the lamp devices:");
        List<Device> lamps = List.of(lamp1, lamp2);
        Device.setPowerForAll(lamps, false);

        // Final count
        countOn = Device.countPoweredOnDevices(devices);
        System.out.println("Final number of devices powered ON: " + countOn);

        // Show final states (polymorphic dynamic binding)
        System.out.println("\n>>> Final states for all devices:");
        for (Device d : devices) {
            d.showStatus(); // dynamic binding: calls subclass implementation
        }
    }
}
