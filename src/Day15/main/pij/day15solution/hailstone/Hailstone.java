package pij.day15solution.hailstone;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to compute the Hailstone sequence for a positive
 * integer number n as a parameter:
 * - If n is 1, the sequence ends.
 * - If n is even, the next number is n/2.
 * - If n is odd, the next number is 3*n + 1.
 * At the point of this writing, it is not known whether there exists some
 * number n that has an infinite Hailstone sequence. The Collatz conjecture
 * states that there is no such n.
 */
public class Hailstone {

    /**
     * Returns the Hailstone sequence from n. Uses 32-bit integer
     * arithmetic, so overflows may happen and lead to incorrect results.
     *
     * @param n the number for which we want to compute the Hailstone sequence
     * @return the Hailstone sequence from n
     * @throws IllegalArgumentException if n is 0 or less
     */
    public static List<Integer> hailstone(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Expected n > 0, found " + n);
        }
        List<Integer> result = new ArrayList<>();
        int current = n;
        while (current > 1) {
            result.add(current);
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = 3*current + 1;
            }
        }
        result.add(current);
        return result;
    }

    /**
     * Returns the Hailstone sequence from n.
     *
     * @param n the number for which we want to compute the Hailstone sequence
     * @return the Hailstone sequence from n
     * @throws NullPointerException if n is null
     * @throws IllegalArgumentException if n is 0 or less
     */
    public static List<BigInteger> hailstoneRedux(BigInteger n) {
        if (n.signum() <= 0) { // or: n.compareTo(BigInteger.ZERO) <= 0
            throw new IllegalArgumentException("Expected n > 0, found " + n);
        }
        List<BigInteger> result = new ArrayList<>();
        BigInteger current = n;
        BigInteger THREE = BigInteger.valueOf(3);
        while (current.compareTo(BigInteger.ONE) > 0) {
            result.add(current);
            if (current.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                current = current.divide(BigInteger.TWO);
            } else {
                current = THREE.multiply(current).add(BigInteger.ONE);
            }
        }
        result.add(current);
        return result;
    }
}
