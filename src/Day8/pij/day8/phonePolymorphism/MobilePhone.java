package pij.day8.phonePolymorphism;

public class MobilePhone extends OldPhone {

    private String[] lastCalledNumbers;
    private int firstInvalidNumber; // initially 0

    private static final int NUMBER_MEMORY_SIZE = 10;

    public MobilePhone(String brand) {
        super(brand);
        lastCalledNumbers = new String[NUMBER_MEMORY_SIZE];
    }

    @Override
    public void call(String number) {
        super.call(number);
        // shift all old entries by old (more efficient solution
        // via modulo possible)
        for (int i = lastCalledNumbers.length - 1; i > 0; i--) {
            // possible optimisation: check for null
            lastCalledNumbers[i] = lastCalledNumbers[i-1];
        }
        lastCalledNumbers[0] = number;
        if (firstInvalidNumber < lastCalledNumbers.length) {
            firstInvalidNumber++;
        }
    }

    public void ringAlarm(String message) {
        System.out.println("Alarm with: " + message);
    }
    public void playGame(String game) {
        System.out.println("Playing " + game + "...");
    }

    /**
     * Prints the last 10 phone numbers that were called on the screen.
     */
    public void printLastNumbers() {
        //System.out.println(java.util.Arrays.toString(lastCalledNumbers));
        //for (int i = 0; i < lastCalledNumbers.length; i++) {
        for (int i = 0; i < firstInvalidNumber; i++) {
            System.out.println(lastCalledNumbers[i]);
        }
    }
}
