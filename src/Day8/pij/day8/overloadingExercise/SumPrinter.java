package pij.day8.overloadingExercise;

public class SumPrinter {

    public static void printSum(int x, int y, String prefix) {
        int sum = x + y;
        System.out.println(prefix + sum);
    }
    public static void printSum(int x, int y) {
        int sum = x + y;
        System.out.println(x + " + " + y + " = " + sum);
    }
    public static void printSum(String x, String y) {
        int xInt = Integer.parseInt(x);
        int yInt = Integer.parseInt(y);
        int sum = xInt + yInt;
        System.out.println(x + " + " + y + " = " + sum);
    }
}
