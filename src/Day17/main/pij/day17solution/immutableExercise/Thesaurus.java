package pij.day17solution.immutableExercise;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A Thesaurus allows its user to look up a set of synonyms for a given word.
 * Immutable class.
 */
public class Thesaurus {

    /** Mapping of words to synonyms. */
    // "final" is not strictly required for immutability of the class, but
    // helps to prevent accidental replacements
    private final Map<String, Set<String>> wordsToSynonyms;

    /**
     * Initialises a new Thesaurus with a given mapping of words to synonyms.
     *
     * @param wordsToSynonyms the mapping of words to synonyms
     * @throws NullPointerException if wordsToSynonyms is null, contains null
     *  as key or value, or one of its values contains null
     */
    public Thesaurus(Map<String, Set<String>> wordsToSynonyms) {
        checkSanity(wordsToSynonyms);
        // we need to make a copy of wordsToSynonyms -- otherwise code external
        // to this class can modify the content of the encapsulated map
        this.wordsToSynonyms = makeUnmodifiableDeepCopy(wordsToSynonyms);
    }

    /**
     * Returns an unmodifiable deep copy of wordsToSynonyms.
     * Here "unmodifiable deep copy" means that also the intermediate data
     * structures (e.g., the values of the map) are copied to unmodifiable
     * structures as needed. Since class String is immutable, its elements
     * do not need to be copied.
     *
     * @param wordsToSynonyms map of which we want to make a deep copy
     * @return an unmodifiable deep copy of wordsToSynonyms
     * @throws NullPointerException if wordsToSynonyms is null or has null
     *  as the value of some entry
     */
    private static Map<String, Set<String>> makeUnmodifiableDeepCopy(Map<String, Set<String>> wordsToSynonyms) {
        // we don't know whether wordsToSynonyms is mutable, so make a copy;
        // just wrapping wordsToSynonyms into an unmodifiable map would not
        // prevent later calls to mutators like put(...) via the reference
        // that was passed to this method
        Map<String, Set<String>> wordsToSynonymsCopy = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : wordsToSynonyms.entrySet()) {
            // class String is immutable, so we do not need a duplicate
            String key = entry.getKey();

            // we don't know whether e.getValue() is mutable, so make a copy;
            // the same considerations as for wordsToSynonyms apply
            Set<String> valueCopy = new LinkedHashSet<>(entry.getValue());
            Set<String> unmodifiableValueCopy = Collections.unmodifiableSet(valueCopy);
            wordsToSynonymsCopy.put(key, unmodifiableValueCopy);
        }
        Map<String, Set<String>> unmodifiableWordsToSynonymsCopy = Collections.unmodifiableMap(wordsToSynonymsCopy);
        return unmodifiableWordsToSynonymsCopy;
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
        // we can return the encapsulated set directly because it is
        // an unmodifiable set of immutable elements
        return this.wordsToSynonyms.get(key);
    }

    /*
    // no mutator methods in an immutable class!
    public void addEntry(String key, Set<String> synonyms) {
        checkSanity(Map.of(key, synonyms));
        this.wordsToSynonyms.put(key, synonyms);
    }
    */

    /**
     * Returns a new Thesaurus object with the same contents as this Thesaurus
     * object, except that key will be mapped to the indicated synonyms.
     *<p>
     * Mutator methods are not allowed in immutable classes. But we /are/
     * allowed to create a new object of the class with the desired properties.
     *
     * @param key the word for which we want to update our synonyms.
     * @param synonyms the set of synonyms
     * @throws NullPointerException if key or synonyms is null, or synonyms
     *  contains null
     */
    public Thesaurus withUpdated(String key, Set<String> synonyms) {
        // ... make a copy of the field of this Thesaurus...
        Map<String, Set<String>> wordsToSynonymsCopy = new LinkedHashMap<>(this.wordsToSynonyms);

        // ... and then put the new entry into the copy
        wordsToSynonymsCopy.put(key, synonyms);

        /* Note that there is no point in making a copy of synonyms:
         * the current constructor of Thesaurus will copy everything, even
         * though the Set<String> objects obtained from this.wordsToSynonyms
         * are already unmodifiable and could be shared.
         *
         * A better solution would be to have a /private/ constructor that does
         * /not/ make a copy, but just stores its argument. The outward-facing
         * way of creating a new Thesaurus object could be a method like
         *
         *    public static Thesaurus create(Map<String, Set<String>> wordsToSynonyms)
         *
         * that checks the "sanity" of the parameter, makes an unmodifiable
         * deep copy, and then passes the unmodifiable deep copy to the
         * constructor.
         *
         * Then our method "withUpdated" would not have to construct all those
         * Set<String> objects again for the new Thesaurus object (that
         * currently happens inside the constructor), but we could just share
         * the references to the unmodifiable Set<String> objects from
         * this.wordsToSynonyms with wordsToSynonymsCopy, and we would have to
         * sanity-check and copy only the parameters to method "withUpdated".
         * This would save a lot of run time and memory.
         *
         * A method like the above "create" is also called a /factory method/.
         * This topic will be covered further in the Software Design and
         * Programming module.
         */

        // not ideal: the constructor does not know that it does not need
        // to recheck and deep-copy everything in its parameter!
        return new Thesaurus(wordsToSynonymsCopy);
    }

    @Override
    public String toString() {
        return this.wordsToSynonyms.toString();
    }
}
