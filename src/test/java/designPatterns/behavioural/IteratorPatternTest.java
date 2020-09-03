package designPatterns.behavioural;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class IteratorPatternTest {

    @Test
    public void nameIteratorTest(){
        NameContainer container = new NameContainer();
        NameIterator iterator = container.getIterator();
        iterator.setNames(Arrays.asList("Hitham", "Ramzy", "Ahmed"));
        assertEquals("Hitham", iterator.getNext());
        assertEquals("Ramzy", iterator.getNext());
        assertTrue(iterator.hasNext());
        assertEquals("Ahmed", iterator.getNext());
        assertFalse(iterator.hasNext());
    }
}
