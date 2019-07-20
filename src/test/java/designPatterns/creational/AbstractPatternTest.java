package designPatterns.creational;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The type Abstract pattern test.
 */
public class AbstractPatternTest {

    /**
     * Gets valid instance.
     */
    @Test
    public void getValidInstance() {
        AbstractPattern.ShapeInterface shape = AbstractPattern.getInstance(AbstractPattern.ShapeType.CIRCLE);
        assertNotNull(shape);
        assertEquals(AbstractPattern.ShapeType.CIRCLE.name(), shape.getType());
    }
}
