package pij.day8.overloading;

/**
 * A Human has a name and an age.
 */
public class Human {

    /** This Human's name. */
    private String name;

    /** This Human's age. */
    private int age;

    /**
     * Constructs a new Human with the given name and an age of 0.
     *
     * @param name the name for this Human
     */
    public Human(String name) {
        this(name, 0);
    }

    /**
     * Constructs a new Human with the given name and age.
     *
     * @param name the name for this Human
     * @param age the age for this Human
     */
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructs a new Human with the same name and age as the other Human.
     * (copy constructor)
     *
     * @param other the Human whose name and age will be copied to this Human
     */
    public Human(Human other) {
        this(other.name, other.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { // same objects always have the same content
            return true;
        }
        if (! (o instanceof Human)) { // also deals with o == null
            return false;
        }
        Human other = (Human) o;
        if (this.name == null) { // either both name variables are null...
            return other.name == null;
        }
        // ...or both are references to Strings with the same content
        return this.name.equals(other.name); // equals(null) should always be false
    }
}
