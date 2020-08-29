package designPatterns.structure;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BridgePatternTest {

    @Test
    public void bridgePatternMobileTest(){

        Mobile mobile = new Mobile(new Ram(2), new HardDrive(256), new Battery(5000));
        assertEquals(
                "Ram with value 2 applied" +
                "HardDrive with value 256 applied" +
                "Battery with value 5000 applied",
                mobile.manufacture());
    }

    @Test
    public void bridgePatternLaptopTest(){

        Laptop laptop = new Laptop(new Ram(8), new HardDrive(2000), new Battery(20000));
        assertEquals(
                "Ram with value 8 applied" +
                "HardDrive with value 2000 applied" +
                "Battery with value 20000 applied",
                laptop.manufacture());
    }

    @Test
    public void bridgePatternPCTest(){

        PC pc = new PC(new Ram(16), new HardDrive(5000), new Battery(0));
        assertEquals(
                "Ram with value 16 applied" +
                "HardDrive with value 5000 applied" +
                "Battery with value 0 applied",
                pc.manufacture());
    }
}
