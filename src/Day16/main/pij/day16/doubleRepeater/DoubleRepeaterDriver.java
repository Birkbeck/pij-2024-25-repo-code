package pij.day16.doubleRepeater;

/**
 * Driver class for DoubleRepeater.
 */
public class DoubleRepeaterDriver {
    public static void main(String[] args) {
        final double INPUT = 256;
        final int TIMES = 3;

        // lambda expression for two times the number
        System.out.println(DoubleRepeater.repeat(null/* TODO */, INPUT, TIMES));

        // Math.sqrt via lambda
        System.out.println(DoubleRepeater.repeat(null/* TODO */, INPUT, TIMES));

        // Math.sqrt via method reference (no ->)
        System.out.println(DoubleRepeater.repeat(null/* TODO */, INPUT, TIMES));
    }
}
