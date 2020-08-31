package designPatterns.structure;

/**
 * The type Facade pattern.
 * <p>
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 */
public class FacadePattern {
    void startCar() {
        ElectricalSystem.check();
        Engine.check();
        Engine.start();
        Car.start();
    }
}


class Car {
    static void start() {
        System.out.println("Car started");
    }
}

class Engine {
    static void start() {
        System.out.println("Engine started");
    }

    static void check() {
        System.out.println("Engine checked");
    }
}

class ElectricalSystem {
    static void check() {
        System.out.println("Electrical System checked");
    }
}
