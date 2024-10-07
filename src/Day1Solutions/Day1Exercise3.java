public class Day1Exercise3 {
    public static void main(String[] args) {
        // This program prints "x is 1" on the screen. This may be surprising
        // because the check x == 2 clearly evaluates to false.
        // Here the author of the code accidentally placed a ";" after the
        // condition of the if statement. This is a common programming mistake
        // in Java: just a ";" is considered as an "empty statement", a
        // statement that does nothing. Everything after that empty statement
        // is considered to be outside the if statement.
        int x = 1;
        if (x == 2); {
            System.out.println("x is " + x);
        }
    }
}
