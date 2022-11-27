package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class DictionaryByTries {
    private static class Node {
        Character character;

        Boolean wordEnd;
        Map<Character, Node> childrenNodes = new HashMap();
    }

    private static final HashMap<Character, Node> parentCharacters = new HashMap<>();


    public static void addValue(String name) {
        int index = 0;
        char currentCharacter = name.charAt(index);
        Node parentNode = parentCharacters.get(currentCharacter);
        if (parentNode == null) {
            parentNode = new Node();
            parentNode.character = currentCharacter;
            parentNode.wordEnd = false;
            parentCharacters.put(currentCharacter, parentNode);
        }
        index++;

        while (index < name.length()) {
            currentCharacter = name.charAt(index);
            Node childNode = parentNode.childrenNodes.get(currentCharacter);
            if (childNode == null) {
                childNode = new Node();
                childNode.character = currentCharacter;
                childNode.wordEnd = false;
                parentNode.childrenNodes.put(currentCharacter, childNode);
            }
            index++;
            parentNode = childNode;
        }
        parentNode.wordEnd = true;
    }

    public static int find(String name) {
        if (name == null || name.length() == 0) {
            return 0;
        }

        Node parentNode = getFirstCharacterNode(name);
        if (parentNode == null) {
            return 0;
        }
        int index = 1;
        while (index < name.length()) {
            char nameCharacter = name.charAt(index);
            Node childCharacter = parentNode.childrenNodes.get(nameCharacter);
            if (childCharacter == null) {
                return 0;
            }
            index++;
            parentNode = childCharacter;
        }
        return getNumberOfChildren(parentNode);
    }

    private static int getNumberOfChildren(Node node) {
        int count = 0;
        if (node.wordEnd) {
            count++;
        }
        for (Node child : node.childrenNodes.values()) {
            count += getNumberOfChildren(child);
        }
        return count;
    }

    private static Node getFirstCharacterNode(String value) {
        char firstLetter = value.charAt(0);
        return parentCharacters.get(firstLetter);
    }


    public static boolean contains(String name) {
        if (name == null || name.length() == 0) {
            return false;
        }

        Node parentNode = getFirstCharacterNode(name);
        if (parentNode == null) {
            return false;
        }
        int index = 1;
        while (index < name.length()) {
            char nameCharacter = name.charAt(index);
            Node childCharacter = parentNode.childrenNodes.get(nameCharacter);
            if (childCharacter == null) {
                return false;
            }
            index++;
            parentNode = childCharacter;
        }
        return true;
    }
}
