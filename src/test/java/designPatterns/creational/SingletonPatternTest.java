package designPatterns.creational;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The type Singleton pattern test.
 */
public class SingletonPatternTest {

    /**
     * Verify same instance.
     */
    @Test
    public void verifySameInstance() {
        SingletonPattern instance1 = SingletonPattern.getInstance();
        SingletonPattern instance2 = SingletonPattern.getInstance();

        assertEquals(instance1.hashCode(), instance2.hashCode());
    }
}
