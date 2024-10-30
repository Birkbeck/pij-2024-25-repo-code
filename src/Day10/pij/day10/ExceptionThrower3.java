package pij.day10;

/**
 * Some practice with Exceptions. Enter a String that cannot be parsed to
 * an int or has length less than 3 and see what happens!
 */
public class ExceptionThrower3 {
    public static void main(String[] args) {
        ExceptionThrower3 et = new ExceptionThrower3();
        et.launch();
    }
    private void launch() {
        System.out.print("Write a number: ");
        int n = getNumber();
        String isOdd = (n % 2 == 0) ? "even" : "odd";
        System.out.println("You entered " + n + ", it is " + isOdd + ".");
    }
    private int getNumber() {
        int result = -1;
        try {
            System.out.print("Enter a number with at least 3 digits: ");
            java.util.Scanner scan = new java.util.Scanner(System.in);
            String str = scan.nextLine();
            result = Integer.parseInt(str);
            System.out.println("You entered " + result + ".");
            char thirdDigit = str.charAt(2);
            System.out.println("The third digit is " + thirdDigit + ".");
        } catch (NumberFormatException ex) {
            System.out.println("ERROR 1: You did not enter an integer.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("ERROR 2: Your integer had less than three digits.");
        }
        return result;
    }
}
