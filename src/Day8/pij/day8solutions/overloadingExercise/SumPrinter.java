package pij.day8solutions.overloadingExercise;

public class SumPrinter {

    public static void printSum(int x, int y, String prefix) {
        int sum = x + y;
        System.out.println(prefix + sum);
    }
    public static void printSum(int x, int y) {
        printSum(x, y, x + " + " + y + " = ");
    }
    public static void printSum(String x, String y) {
        int xInt = Integer.parseInt(x);
        int yInt = Integer.parseInt(y);
        printSum(xInt, yInt);
    }


    public static int sumUp(int x, int y) {
        return x+y;
    }
    public static int sumUp(int x, int y, int z) {
        return x+y+z;
    }
    public static int sumUp(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

}
