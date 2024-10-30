package pij.day10;

/**
 * Some practice with Exceptions. Enter a String that cannot be parsed to
 * an int and see what happens!
 */
public class ExceptionThrower {
    public static void main(String[] args) {
        ExceptionThrower et = new ExceptionThrower();
        et.launch();
    }
    private void launch() {
        System.out.print("Write a number: ");
        int n = getNumber();
        String isOdd = (n % 2 == 0) ? "even" : "odd";
        System.out.println("You entered " + n + ", it is " + isOdd + ".");
    }

    /**
     * Gets a number as introduced by the user on the console, which must be at
     * least three digits long. Otherwise, an IndexOutOfBoundsException will be
     * thrown.
     *
     * @return the number introduced by the user
     *
     * @throws NumberFormatException if the user types a non-number
     * @throws IndexOutOfBoundsException if the user types less than three digits
     */
    private int getNumber() {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String str = scan.nextLine();
        int result = Integer.parseInt(str);
        return result;
    }
}
