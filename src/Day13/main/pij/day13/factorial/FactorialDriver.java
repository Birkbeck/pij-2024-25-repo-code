package pij.day13.factorial;

/**
 * Driver class for class Factorial.
 */
public class FactorialDriver {
    public static void main(String[] args) {
        int input = 4;
        int result = Factorial.factorial(input);
        System.out.println("The factorial of " + input + " is " + result + ".");
    }
}
