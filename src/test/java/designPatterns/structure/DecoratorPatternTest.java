package designPatterns.structure;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DecoratorPatternTest {

    @Test
    public void decoratorPatternTest() {
        Shape redShape = new RedDecorator(new Circle());
        assertEquals("Red Shape drown", redShape.draw());
    }
}
