package designPatterns.behavioural;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NullObjectPatternTest {

    @Test
    public void nullObjectPatternTest() {
        assertEquals("Hitham", NullObjectPattern.getCustomer("Hitham").getName());
        assertEquals("NULL OBJECT", NullObjectPattern.getCustomer("XXX").getName());
    }
}
