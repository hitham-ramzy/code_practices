package designPatterns.behavioural;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandPatternTest {

    @Test
    public void turnOnTest(){
        List<Device> devices = Arrays.asList(new Lamp(), new Fan(), new AC());
        Switch s = new Switch(devices);
        assertEquals("Lamp turned on, Fan turned on, AC turned on",s.turnOn());
    }

    @Test
    public void turnOffTest(){
        List<Device> devices = Arrays.asList(new Lamp(), new Fan(), new AC());
        Switch s = new Switch(devices);
        assertEquals("Lamp turned off, Fan turned off, AC turned off",s.turnOff());
    }
}
