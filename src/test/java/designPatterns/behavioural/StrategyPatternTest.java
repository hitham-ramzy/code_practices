package designPatterns.behavioural;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrategyPatternTest {

    @Test
    public void HighDiscountTest() {
        StrategyPattern strategyPattern = new StrategyPattern(new StrategyPattern.HightDiscountStrategy());
        Double billAmount = strategyPattern.applyDiscount(100D);
        assertEquals(50, billAmount, 0.0);
    }

    @Test
    public void LowDiscountTest() {
        StrategyPattern strategyPattern = new StrategyPattern(new StrategyPattern.LowDiscountStrategy());
        Double billAmount = strategyPattern.applyDiscount(100D);
        assertEquals(90, billAmount, 0.0);
    }

    @Test
    public void NoDiscountTest() {
        StrategyPattern strategyPattern = new StrategyPattern(new StrategyPattern.NoDiscountStrategy());
        Double billAmount = strategyPattern.applyDiscount(100D);
        assertEquals(100, billAmount, 0.0);
    }

}
