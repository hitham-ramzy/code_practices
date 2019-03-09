package problemSolving;

import java.util.Stack;

public class BalancedParentheses {

    private static Stack<Character> charsStack = new Stack<Character>();
    private static final char[][] BRACKETS = {{'[', ']'}, {'(', ')'}, {'{', '}'}};

    public static boolean testString(String stringToTest) {

        char[] charToTest = stringToTest.toCharArray();
        for (char c : charToTest) {
            if (isOpenTerm(c)) {
                charsStack.push(c);
            } else {
                if (charsStack.empty() || !isCloseOf(charsStack.peek(), c)) {
                    return false;
                }
                charsStack.pop();
            }
        }
        return true;
    }

    private static boolean isOpenTerm(char c) {
        for (char[] arr : BRACKETS) {
            if (arr[0] == c) return true;
        }
        return false;
    }

    private static boolean isCloseOf(char openTerm, char closeTerm) {
        for (char[] arr : BRACKETS) {
            if (arr[0] == openTerm) return arr[1] == closeTerm;
        }
        return false;
    }
}
