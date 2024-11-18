package pij.day16.map;

/**
 * Utility class with mathematical functionality that is missing in class Math.
 * Provides a static method factorial.
 */
public class MyMath {

    /**
     * Private constructor to ensure that the class cannot be instantiated.
     */
    private MyMath() {}

    /**
     * Returns the factorial of n for the type int if n is greater than 0,
     * 1 otherwise.
     *
     * @param n the number whose factorial we want to computer
     * @return the factorial of n for the type int if n is greater than 0,
     *   1 otherwise
     */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

