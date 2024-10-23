package pij.day8.phonePolymorphism;

/**
 * A Phone makes calls to given phone numbers.
 */
public interface Phone {
    /**
     * Just print on the screen: "Calling <number>..."
     *
     * @param number the phone number to call
     */
    void call(String number);
}
