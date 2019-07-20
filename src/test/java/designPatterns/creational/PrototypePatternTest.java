package designPatterns.creational;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PrototypePatternTest {

    @Test
    public void getInstance() throws CloneNotSupportedException {
        PrototypePattern.loadCahche();
        PrototypePattern.ShapeClass shapeClass = PrototypePattern.getInstance(1L);
        assertNotNull(shapeClass);
    }
}
