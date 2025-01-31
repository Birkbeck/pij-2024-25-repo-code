package pij.day16solution.shape;

import pij.day16.shape.OneDimensionalShape;
import pij.day16.shape.TwoDimensionalShape;

/**
 * Driver class for OneDimensionalShape and TwoDimensionalShape object
 * creation by lambda expressions where possible.
 */
public class ShapeDriver {
    public static void main(String[] args) {
        OneDimensionalShape s1 = () -> 2.5; // yes, although it is not too exciting
        TwoDimensionalShape s2 = null; // no, it is not a functional interface (2 abstract methods)
        System.out.println(s1.getHeight());
    }
}
