package pij.day8.overloading;

/**
 * Some examples on method overloading from the slides of Day 8.
 */
public class MethodOverloading {
    /*
    public int m1(Object o) { return 0; }
    public int m1(String s) { return 0; }
    public int m2(String o) { return 0; }
    public int m2(String s) { return 0; }
    public int m3(String o) { return 0; }
    public String m3(String s) { return null; }
    public int m4(double i, String s) { return 0; }
    public int m4(String s, double i) { return 0; }
    */

    public void printAverage(double d1, double d2, String msg) {
        double result = 0.5 * (d1 + d2);
        System.out.println(msg + result);
    }

    public void printAverage(double d1, double d2) {
        printAverage(d1, d2, "The average is: ");
    }

}
