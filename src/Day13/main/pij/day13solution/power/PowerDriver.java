package pij.day13solution.power;

public class PowerDriver {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println(base + "^" + exponent + " = "
                + Power.powRecursive(base, exponent) + " (by recursion)");
        System.out.println(base + "^" + exponent + " = "
                + Power.powIterative(base, exponent) + " (by iteration)");
    }
}
