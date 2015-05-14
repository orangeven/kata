package de.berlin.kata.conflictingObjectives;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ExtendibleIComposedWordFinder implements IComposedWordFinder {
    private final static Logger log = Logger.getLogger(ExtendibleIComposedWordFinder.class.getName());
    private WordLoader wordLoader = new WordLoader();
    private IComposedWordResolver composedWordResolver = new ComposedWordResolver(wordLoader);

    @Override
    public Set<String> getComposedWords(int wordLength) {
        Set<String> composedWords = new LinkedHashSet<>();
        Set<String> words = wordLoader.getWords(wordLength);
        words.forEach(word -> {
            if (composedWordResolver.isComposed(word)) {
                composedWords.add(word);
            }
        });

        return composedWords;
    }
}
