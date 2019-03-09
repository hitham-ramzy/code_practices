package dataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import problemSolving.BalancedParentheses;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedParenthesesTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting BalancedParenthesesTest...");
    }

    @Test
    public void balancedString() {
        final String balancedString = "{}[](([{}]))";
        assertTrue(BalancedParentheses.testString(balancedString));
    }

    @Test
    public void unbalancedString() {
        final String unbalancedString = "{}[](([{{]))";
        assertFalse(BalancedParentheses.testString(unbalancedString));
    }

    @Test
    public void emptyString() {
        assertTrue(BalancedParentheses.testString(""));
    }

    @Test
    public void specialCharactersString() {
        final String s = "!@#$%^&*(";
        assertFalse(BalancedParentheses.testString(s));
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Ending BalancedParenthesesTest...");
    }
}
