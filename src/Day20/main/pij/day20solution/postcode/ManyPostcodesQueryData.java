package pij.day20solution.postcode;

import java.util.Arrays;

/**
 * Represents JSON data for POST request to http://api.postcodes.io/postcodes
 * For Exercise 1.7.
 */
public class ManyPostcodesQueryData {

    /** An array of Strings holds the actual payload data. */
    private String[] postcodes;

    /**
     * @param postcodes reference to be stored inside this object
     */
    public ManyPostcodesQueryData(String[] postcodes) {
        this.postcodes = postcodes;
    }


    @Override
    public String toString() {
        return "ManyPostcodesQueryData{" +
                "postcodes=" + Arrays.toString(this.postcodes) +
                '}';
    }
}