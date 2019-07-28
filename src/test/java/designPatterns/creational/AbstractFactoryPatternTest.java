package designPatterns.creational;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AbstractFactoryPatternTest {

    private static AbstractFactoryPattern abstractFactoryPattern;

    @BeforeClass
    public static void setup() {
        abstractFactoryPattern = new AbstractFactoryPattern();
    }

    @Test
    public void testSquare() {
        AbstractFactoryPattern.AbstractFactory abstractFactory = abstractFactoryPattern.getFactory(false);
        AbstractFactoryPattern.Shape squareShape = abstractFactory.getShape("SQUARE");
        assertEquals("Square", squareShape.getName());
    }

    @Test
    public void testRoundedSquare() {
        AbstractFactoryPattern.AbstractFactory roundedAbstractFactory = abstractFactoryPattern.getFactory(true);
        AbstractFactoryPattern.Shape roundedSquareShape = roundedAbstractFactory.getShape("SQUARE");
        assertEquals("RoundedSquare", roundedSquareShape.getName());
    }

    @Test
    public void testRectangle() {
        AbstractFactoryPattern.AbstractFactory abstractFactory = abstractFactoryPattern.getFactory(false);
        AbstractFactoryPattern.Shape rectangleShape = abstractFactory.getShape("Rectangle");
        assertEquals("Rectangle", rectangleShape.getName());
    }

    @Test
    public void testRoundedRectangle() {
        AbstractFactoryPattern.AbstractFactory roundedAbstractFactory = abstractFactoryPattern.getFactory(true);
        AbstractFactoryPattern.Shape roundedSquareShape = roundedAbstractFactory.getShape("Rectangle");
        assertEquals("RoundedRectangle", roundedSquareShape.getName());
    }

    @Test
    public void testNullShape() {
        AbstractFactoryPattern.AbstractFactory roundedAbstractFactory = abstractFactoryPattern.getFactory(true);
        AbstractFactoryPattern.Shape nullShape = roundedAbstractFactory.getShape("NOT_FOUND_VALUE");
        assertNull(nullShape);
    }

}
