package pij.day16.map;

import java.util.Arrays;

/**
 * Driver class for class Shifter.
 */
public class ShifterDriver {
    public static void main(String[] args) {
        Shifter s = new Shifter(10);
        int[] myData = { 5, 6, 7, 8 };
        int[] shifted1 = s.shiftAll(myData);
        int[] shifted2 = Shifter.shiftAll(s, myData);

        System.out.println(Arrays.toString(myData));
        System.out.println(Arrays.toString(shifted1));
        System.out.println(Arrays.toString(shifted2));

        Shifter[] shifters = { new Shifter(12), new Shifter(8), new Shifter(10) };
        System.out.println(Arrays.toString(shifters));

        Shifter.sortShifters(shifters);
        System.out.println(Arrays.toString(shifters));
    }
}
