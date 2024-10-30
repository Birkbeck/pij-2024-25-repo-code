package pij.day10;

/**
 * Some practice with Exceptions. Enter a String that cannot be parsed to
 * an int and see what happens!
 */
public class ExceptionThrower2 {
    public static void main(String[] args) {
        ExceptionThrower2 et = new ExceptionThrower2();
        et.launch();
    }
    private void launch() {
        System.out.print("Write a number: ");
        int n = getNumber();
        String isOdd = (n % 2 == 0) ? "even" : "odd";
        System.out.println("You entered " + n + ", it is " + isOdd + ".");
    }
    private int getNumber() {
        int result = -1; // default, so we have /some/ value to return in all cases
        try {
            java.util.Scanner scan = new java.util.Scanner(System.in);
            String str = scan.nextLine();
            result = Integer.parseInt(str);
            System.out.println("You entered " + result + ".");
        } catch (NumberFormatException ex) {
            System.out.println("What you entered is not an integer number!");
        }
        return result;
    }
}
