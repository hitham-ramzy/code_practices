package designPatterns.structure;

/**
 * The type Decorator pattern.
 *
 * Used when you need to add a new functionality to an existing object without altering its structure
 */
public class DecoratorPattern {
}


interface Shape {

    String draw();
}

class Triangle implements Shape{

    @Override
    public String draw() {
        return "Draw a Triangle";
    }
}

class Circle implements Shape{

    @Override
    public String draw() {
        return "Draw a Circle";
    }
}

abstract class ShapeDecorator implements Shape {

    Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String draw() {
        return shape.draw();
    }
}

class RedDecorator extends ShapeDecorator {

    String color;

    public RedDecorator(Shape shape) {
        super(shape);
        setColor("RED");
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String draw() {
        return "Red Shape drown";
    }
}


