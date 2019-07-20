package designPatterns.creational;

/**
 * The type Abstract pattern.
 */
public class FactoryPattern {

    /**
     * Gets instance.
     *
     * @param shapeType the shape type
     * @return the instance
     */
    public static ShapeInterface getInstance(ShapeType shapeType) {
        if (ShapeType.CIRCLE.equals(shapeType)) {
            return new Circle();
        } else if (ShapeType.SQUARE.equals(shapeType)) {
            return new Square();
        }
        return null;
    }

    /**
     * The enum Shape type.
     */
    enum ShapeType {
        /**
         * Circle shape type.
         */
        CIRCLE,
        /**
         * Square shape type.
         */
        SQUARE
    }

    /**
     * The interface Shape interface.
     */
    interface ShapeInterface {
        /**
         * Gets type.
         *
         * @return the type
         */
        String getType();
    }

    /**
     * The type Circle.
     */
    static class Circle implements ShapeInterface {
        @Override
        public String getType() {
            return "CIRCLE";
        }
    }

    /**
     * The type Square.
     */
    static class Square implements ShapeInterface {
        @Override
        public String getType() {
            return "Square";
        }
    }

}
