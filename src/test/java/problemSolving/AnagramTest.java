package problemSolving;

import junit.framework.TestCase;

public class AnagramTest extends TestCase {

    public void testAnagram(){
        assertEquals(2, Anagram.charactersToRemove("hitham", "htih"));
    }
}