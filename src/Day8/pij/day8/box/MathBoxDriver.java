package pij.day8.box;

import java.math.BigInteger;

/**
 * A driver class (aka script, aka tester class) for the MathBox&lt;T&gt;
 * type, with non-compiling lines commented out.
 */
public class MathBoxDriver {
    public static void main(String[] args) {
        MathBox<Integer> intBox = new MathBox<>(5); // ok: 5 is auto-boxed into Integer
        MathBox<Double> doubleBox = new MathBox<>(32.1); // ok: 32.1 is auto-boxed into Double
        MathBox<BigInteger> bigIntegerBox = new MathBox<>(BigInteger.valueOf(8000)); // ok: BigInteger is also a Number
        //MathBox<String> strBox = new MathBox<>("No good!"); // compile-term error
    }
}
