package pij.day8.personPolymorphism;

/**
 * A person is defined by movement (as opposed to plants)
 * and by making verbal statements (as opposed to animals).
 */
public interface Person {
    /**
     * Move a distance in a straight line, given in metres.
     * @param distance distance in metres to move
     */
    void move(int distance);

    /**
     * Make a verbal statement, printing it on screen.
     * It may or may not be a perfect transcription.
     * @param message the message to use for the verbal statement
     */
    void makeVerbalStatement(String message);
}
