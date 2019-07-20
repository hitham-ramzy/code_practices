package designPatterns.creational;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The type Abstract pattern test.
 */
public class FactoryPatternTest {

    /**
     * Gets valid instance.
     */
    @Test
    public void getValidInstance() {
        FactoryPattern.ShapeInterface shape = FactoryPattern.getInstance(FactoryPattern.ShapeType.CIRCLE);
        assertNotNull(shape);
        assertEquals(FactoryPattern.ShapeType.CIRCLE.name(), shape.getType());
    }
}
