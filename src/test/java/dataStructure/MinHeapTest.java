package dataStructure;

import junit.framework.TestCase;
import org.junit.Assert;

public class MinHeapTest extends TestCase {

    public void testMinHeap(){
        MinHeap.add(4);
        MinHeap.add(5);
        MinHeap.add(3);
        MinHeap.add(1);
        MinHeap.add(2);

        Assert.assertEquals(1, MinHeap.peak());
        Assert.assertEquals(1, MinHeap.poll());
        Assert.assertEquals(2, MinHeap.peak());
    }

}