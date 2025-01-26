package pij.day13solution.factorial;

import pij.day13solution.power.Power;

public class FactorialDriver {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("factorial(" + n + ") = "
                + Factorial.factorialRecursive(n) + " (by recursion)");
        System.out.println("factorial(" + n + ") = "
                + Factorial.factorialIterative(n) + " (by iteration)");
    }
}
