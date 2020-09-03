package designPatterns.behavioural;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandPattern {
}

interface Device {
    String turnOn();

    String turnOff();
}

class Lamp implements Device {

    @Override
    public String turnOn() {
        return "Lamp turned on";
    }

    @Override
    public String turnOff() {
        return "Lamp turned off";
    }
}

class Fan implements Device {

    @Override
    public String turnOn() {
        return "Fan turned on";
    }

    @Override
    public String turnOff() {
        return "Fan turned off";
    }
}

class AC implements Device {

    @Override
    public String turnOn() {
        return "AC turned on";
    }

    @Override
    public String turnOff() {
        return "AC turned off";
    }
}

class Switch {

    List<Device> devices = new ArrayList<>();

    public Switch(List<Device> devices) {
        this.devices = devices;
    }

    String turnOn() {
        return devices.stream().map(Device::turnOn).collect(Collectors.joining(", "));
    }

    String turnOff() {
        return devices.stream().map(Device::turnOff).collect(Collectors.joining(", "));
    }
}
