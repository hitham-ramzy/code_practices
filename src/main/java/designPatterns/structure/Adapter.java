package designPatterns.structure;

/**
 * The Adapter Class.
 * <p>
 * An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly.
 * An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface.
 * @author hitham.ramzy
 *
 */
class Adapter {

    /**
     * The interface Movable.
     */
    public interface Movable {
        /**
         * Gets speed.
         *
         * @return the speed
         */
        Double getSpeed();
    }

    /**
     * The type Proton car.
     */
    public static class ProtonCar implements Movable {

        @Override
        public Double getSpeed() {
            return 350D;
        }
    }

    /**
     * The interface Movable adapter.
     */
    public interface MovableAdapter {
        /**
         * Gets speed.
         *
         * @return the speed
         */
        Double getSpeed();
    }

    /**
     * The type Movable adapter.
     */
    public static class MovableAdapterImpl implements MovableAdapter {
        private Movable luxuryCars;

        /**
         * Instantiates a new Movable adapter.
         *
         * @param luxuryCars the luxury cars
         */
        MovableAdapterImpl(Movable luxuryCars) {
            this.luxuryCars = luxuryCars;
        }

        @Override
        public Double getSpeed() {
            return convertMPHtoKMPH(luxuryCars.getSpeed());
        }

        private double convertMPHtoKMPH(double mph) {
            return mph * 1.60934;
        }
    }

}
