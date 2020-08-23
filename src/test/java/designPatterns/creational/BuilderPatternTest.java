package designPatterns.creational;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderPatternTest {

    @Test
    public void testBuilderPattern() {
        ICarBuilder carBuilder = BuilderPattern.getCarBuilder();
        Car car = carBuilder.setId(1L).setModel("FIAT").setYear(2021).setColor("RED").build();
        assertEquals(1L, Long.parseLong("" + car.id));
    }

    @Test(expected = RuntimeException.class)
    public void testBuilderPatternError() {
        ICarBuilder carBuilder = BuilderPattern.getCarBuilder();
        carBuilder.setModel("FIAT").setId(1L).setYear(2021).setColor("RED").build();
    }

}
