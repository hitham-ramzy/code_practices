package designPatterns.structure;

/**
 * The Bridge pattern.
 * <p>
 * Aims to decouple the abstraction and the implementation.
 * <p>
 * By separating the Core entities from its specs
 * <p>
 * The specs will have a super class used as a reference in the code entity
 */
public class BridgePattern {
}


abstract class Device {
    private Specification specification1;
    private Specification specification2;
    private Specification specification3;

    public Device(Specification specification1, Specification specification2, Specification specification3) {
        this.specification1 = specification1;
        this.specification2 = specification2;
        this.specification3 = specification3;
    }

    String manufacture() {
        return specification1.apply() +
                specification2.apply() +
                specification3.apply();
    }
}

class Mobile extends Device {

    public Mobile(Specification specification1, Specification specification2, Specification specification3) {
        super(specification1, specification2, specification3);
    }
}

class Laptop extends Device {

    public Laptop(Specification specification1, Specification specification2, Specification specification3) {
        super(specification1, specification2, specification3);
    }
}

class PC extends Device {

    public PC(Specification specification1, Specification specification2, Specification specification3) {
        super(specification1, specification2, specification3);
    }
}

abstract class Specification {
    int value;

    Specification(int value) {
        this.value = value;
    }

    abstract String apply();
}

class Ram extends Specification {

    Ram(int value) {
        super(value);
    }

    @Override
    String apply() {
        return "Ram with value " + value + " applied";
    }
}

class HardDrive extends Specification {

    HardDrive(int value) {
        super(value);
    }

    @Override
    String apply() {
        return "HardDrive with value " + value + " applied";
    }
}

class Battery extends Specification {

    Battery(int value) {
        super(value);
    }

    @Override
    String apply() {
        return "Battery with value " + value + " applied";
    }
}
