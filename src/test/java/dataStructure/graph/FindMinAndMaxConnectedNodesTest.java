package dataStructure.graph;

import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindMinAndMaxConnectedNodesTest {

    @Test
    public void testMinAndMaxConnectedNodes(){
        List<List<Integer>> nodes = new ArrayList<>();
        // [[1, 6],[2, 7], [3, 8], [4,9], [2, 6]]
        nodes.add(List.of(1, 6));
        nodes.add(List.of(2, 7));
        nodes.add(List.of(3, 8));
        nodes.add(List.of(4, 9));
        nodes.add(List.of(2, 6));
        assertEquals(List.of(2, 4), FindMinAndMaxConnectedNodes.componentsInGraph(nodes));
    }
}