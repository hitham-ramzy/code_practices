package dataStructure;

import junit.framework.TestCase;
import org.junit.Assert;

public class MaxHeapTest extends TestCase {

    public void testMaxHeap() {
        MaxHeap.add(3);
        MaxHeap.add(4);
        MaxHeap.add(5);
        MaxHeap.add(1);
        MaxHeap.add(2);

        Assert.assertEquals(5, MaxHeap.peak());
        Assert.assertEquals(5, MaxHeap.poll());
        Assert.assertEquals(4, MaxHeap.peak());
    }
}