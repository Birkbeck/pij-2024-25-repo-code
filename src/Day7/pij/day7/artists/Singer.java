package pij.day7.artists;

/**
 * A Singer has a name and can sing songs.
 */
public class Singer {

    /** The name of this Singer. */
    private String name;

    /**
     * Creates a new Singer with a given name.
     *
     * @param name the name of this Singer
     */
    public Singer(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this Singer.
     *
     * @return the name of this Singer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sings a specific song.
     *
     * @param song the song to sing
     */
    public void sing(String song) {
        System.out.println("Singing song: " + song);
    }
}
