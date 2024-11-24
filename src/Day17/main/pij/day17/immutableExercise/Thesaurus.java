package pij.day17.immutableExercise;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A Thesaurus allows its user to look up a set of synonyms for a given word.
 */
public class Thesaurus {

    /** Mapping of words to synonyms. */
    private Map<String, Set<String>> wordsToSynonyms;

    /**
     * Initialises a new Thesaurus with a given mapping of words to synonyms.
     *
     * @param wordsToSynonyms the mapping of words to synonyms
     * @throws NullPointerException if wordsToSynonyms is null, contains null
     *  as key or value, or one of its values contains null
     */
    public Thesaurus(Map<String, Set<String>> wordsToSynonyms) {
        checkSanity(wordsToSynonyms);
        this.wordsToSynonyms = wordsToSynonyms;
    }

    /**
     * Sanity check for map from words to synonyms. Throws NullPointerException
     * if wordsToSynonyms is null, contains null as key or value, or one of its
     * values contains null.
     *
     * @param wordsToSynonyms the map from words to synonyms to check for
     *                        absence of reachable null references
     * @throws NullPointerException if wordsToSynonyms is null, contains null
     *  as key or value, or one of its values contains null
     */
    private static void checkSanity(Map<String, Set<String>> wordsToSynonyms) {
        Objects.requireNonNull(wordsToSynonyms);
        for (Map.Entry<String, Set<String>> entry : wordsToSynonyms.entrySet()) {
            Objects.requireNonNull(entry.getKey());
            Objects.requireNonNull(entry.getValue());
            for (String s : entry.getValue()) {
                Objects.requireNonNull(s);
            }
        }
    }

    /**
     * Returns the set of known synonyms for key, or null if key is unknown.
     *
     * @param key the word whose synonyms should be retrieved
     * @return the set of known synonyms for key, or null if key is unknown
     */
    public Set<String> getSynonyms(String key) {
        return this.wordsToSynonyms.get(key);
    }

    /**
     * Adds or modifies an entry of synonyms for the word key.
     *
     * @param key the word for which we want to update our synonyms.
     * @param synonyms the set of synonyms
     * @throws NullPointerException if key or synonyms is null
     */
    public void addEntry(String key, Set<String> synonyms) {
        checkSanity(Map.of(key, synonyms));
        this.wordsToSynonyms.put(key, synonyms);
    }

    @Override
    public String toString() {
        return this.wordsToSynonyms.toString();
    }
}
