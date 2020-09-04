package designPatterns.behavioural;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusPatternTest {

    @Test
    public void orderStatusTest() {
        Order order = new Order();
        assertEquals(OrderCreated.class, order.getStatus().getClass());
        assertEquals("Order received", order.receive());
        assertEquals(OrderReceived.class, order.getStatus().getClass());
        assertEquals("Order closed", order.close());
    }

    @Test(expected = RuntimeException.class)
    public void changeOrderInvalidStatusTest() {
        Order order = new Order();
        order.close();
    }
}
