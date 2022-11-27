package problemSolving;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DictionaryByTriesTest extends TestCase {

    @Test
    public void testSearch() {
        DictionaryByTries.addValue("Hitham Ramzy");
        DictionaryByTries.addValue("HithRamzy");
        DictionaryByTries.addValue("hack");
        DictionaryByTries.addValue("hackerrank");
        Assert.assertFalse(DictionaryByTries.contains("Name"));
        Assert.assertTrue(DictionaryByTries.contains("Hitham "));
        Assert.assertEquals(2, DictionaryByTries.find("hac"));
    }
}