package pij.day8.box;

import java.math.BigInteger;

/**
 * A driver class (aka script, aka tester class) for the ImprovedMathBox&lt;T&gt;
 * type, with non-compiling lines commented out.
 */
public class ImprovedMathBoxDriver {
    public static void main(String[] args) {
        ImprovedMathBox<Integer> intBox = new ImprovedMathBox<>(5); // ok: 5 is auto-boxed into Integer
        ImprovedMathBox<Double> doubleBox = new ImprovedMathBox<>(32.1); // ok: 32.1 is auto-boxed into Double
        ImprovedMathBox<BigInteger> bigIntegerBox = new ImprovedMathBox<>(BigInteger.valueOf(8000)); // ok: BigInteger is also a Number
        //ImprovedMathBox<String> strBox = new ImprovedMathBox<>("No good!"); // compile-term error
    }
}
