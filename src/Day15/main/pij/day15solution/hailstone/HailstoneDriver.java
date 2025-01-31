package pij.day15solution.hailstone;

import java.math.BigInteger;

/**
 * Driver class for the Hailstone sequence.
 */
public class HailstoneDriver {
    public static void main(String[] args) {
        int n = 3;
        BigInteger nBig = BigInteger.valueOf(n);
        System.out.println(Hailstone.hailstone(n));
        System.out.println(Hailstone.hailstoneRedux(nBig));
    }
}
