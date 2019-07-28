package designPatterns.creational;

class AbstractFactoryPattern {

    interface Shape {
        String getName();
    }

    private class RoundedRectangle implements Shape {
        @Override
        public String getName() {
            return "RoundedRectangle";
        }
    }

    private class RoundedSquare implements Shape {
        @Override
        public String getName() {
            return "RoundedSquare";
        }
    }

    private class Rectangle implements Shape {
        @Override
        public String getName() {
            return "Rectangle";
        }
    }

    private class Square implements Shape {
        @Override
        public String getName() {
            return "Square";
        }
    }

    abstract class AbstractFactory {
        abstract Shape getShape(String shapeType);
    }

    private class ShapeFactory extends AbstractFactory {
        @Override
        public Shape getShape(String shapeType) {
            if (shapeType.equalsIgnoreCase("RECTANGLE")) {
                return new Rectangle();
            } else if (shapeType.equalsIgnoreCase("SQUARE")) {
                return new Square();
            }
            return null;
        }
    }

    private class RoundedShapeFactory extends AbstractFactory {
        @Override
        public Shape getShape(String shapeType) {
            if (shapeType.equalsIgnoreCase("RECTANGLE")) {
                return new RoundedRectangle();
            } else if (shapeType.equalsIgnoreCase("SQUARE")) {
                return new RoundedSquare();
            }
            return null;
        }
    }

    AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
