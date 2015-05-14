package de.berlin.kata.conflictingObjectives;

import java.util.Set;
import java.util.logging.Logger;

public class ComposedWordResolver implements IComposedWordResolver {
    private final static Logger log = Logger.getLogger(ComposedWordResolver.class.getName());

    private final WordLoader wordLoader;

    public ComposedWordResolver(WordLoader wordLoader) {
        this.wordLoader = wordLoader;
    }

    @Override
    public boolean isComposed(String word) {
        for (int index = 1; index <= word.length() - 1; index++) {
            String firstWord = word.substring(0, index);
            String secondWord = word.substring(index);

            if (isWordExist(firstWord) && isWordExist(secondWord)) {
                log.fine("Found composed word: " + word + " = " + firstWord + " + " + secondWord);
                return true;
            }
        }
        return false;
    }

    private boolean isWordExist(String word) {
        Set<String> words = wordLoader.getWords(word.length());
        return words.contains(word);
    }

}
