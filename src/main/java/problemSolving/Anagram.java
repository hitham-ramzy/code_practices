package problemSolving;

/**
 * The type Anagram.
 * How many characters do you want to remove from either to make them anagram
 */
public class Anagram {

    private static final int CHARACTER_NUMBER = 26;


    /**
     * Characters to remove int.
     *
     * @param word1 the word 1
     * @param word2 the word 2
     * Save the characters count of both strings into an array of length 26 (number of alphabets)
     * Then get the diff of each index
     *
     * @return the int
     */
    public static int charactersToRemove(String word1, String word2) {
        int[] array1 = new int[CHARACTER_NUMBER];
        int[] array2 = new int[CHARACTER_NUMBER];

        for (int c : word1.chars().toArray()) {
            int characterIndex = getCharacterIndex(c);
            array1[characterIndex] = array1[characterIndex] + 1;
        }

        for (int c : word2.chars().toArray()) {
            int characterIndex = getCharacterIndex(c);
            array2[characterIndex]++;
        }

        int result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += Math.abs(array1[i] - array2[i]);
        }
        return result;
    }

    private static int getCharacterIndex(int c) {
        return c - 'a';
    }

}
