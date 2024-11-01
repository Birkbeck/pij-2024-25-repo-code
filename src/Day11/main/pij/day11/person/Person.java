package pij.day11.person;

import java.util.Objects;

/**
 * This class provides a minimal modelling of the concept of a Person
 * with a name that can consist of several parts. The class provides
 * a method to extract a person's initials from their name.
 */
public class Person {
    /** Field for the Person's full name. Never null. */
    private String fullName;

    /**
     * Initialises a new Person object with a given full name.
     *
     * @param fullName the Person's full name
     * @throws NullPointerException if fullName is the null reference
     */
    public Person(String fullName) {
        this.fullName = Objects.requireNonNull(fullName, "fullName must not be null!");
    }

    /**
     * Returns this Person's initials as a String. For example, if this Person
     * was created with "George Birkbeck" as the full name, this method will
     * return "GB".
     *
     * @return this Person's initials as a String
     */
    public String getInitials() {
        String result = "";
        String[] words = this.fullName.split(" ");
        for (int i = 0; i < words.length; i++) {
            String nextInitial = "" + words[i].charAt(0);
            result = result + nextInitial.toUpperCase();
        }
        return result;
    }
}
