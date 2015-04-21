package de.berlin.kata.wordChains;

/**
 * @author weng
 *         created: 17.04.15 - 16:13
 */
public class WordChainTransitionRule {

    public static boolean isTransitionPossible(Node startNode, Node endNode) {
        String startWord = startNode.getValue();
        String endWord = endNode.getValue();
        boolean theSameLength = startWord.length() == endWord.length();
        return theSameLength && hasOnlyOneDiffChar(startWord, endWord);
    }

    private static boolean hasOnlyOneDiffChar(String startWord, String endWord) {
        int diffCounter = 0;
        for (int i = 0; i < startWord.length(); i++) {
            char startChar = startWord.charAt(i);
            char endChar = endWord.charAt(i);
            if (startChar != endChar) {
                diffCounter++;
            }

            if (diffCounter > 1) {
                break;
            }
        }
        return diffCounter == 1;
    }


}
