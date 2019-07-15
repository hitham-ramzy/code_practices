package designPatterns.structure;

import designPatterns.structure.Adapter.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdapterTest {
    @Test
    public void convertMPHtoKMPH() {
        Movable protonCar = new ProtonCar();
        MovableAdapter protonMovableAdapter = new MovableAdapterImpl(protonCar);
        assertEquals(563.269, protonMovableAdapter.getSpeed(), 0.00001);
    }
}
