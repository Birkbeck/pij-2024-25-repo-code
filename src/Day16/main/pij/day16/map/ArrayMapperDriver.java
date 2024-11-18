package pij.day16.map;

/**
 * Driver class for method map in class ArrayMapper.
 */
public class ArrayMapperDriver {
    public static void main(String[] args) {
        int[] myData = { 5, 6, 7, 8 };
        int[] array1 = ArrayMapper.map(new AddOneFunction(), myData);
        int[] array2 = ArrayMapper.map(new MultiplyByTwoFunction(), myData);

        System.out.println(java.util.Arrays.toString(myData));
        System.out.println(java.util.Arrays.toString(array1));
        System.out.println(java.util.Arrays.toString(array2));

        IntToIntFunction myF1 = (int input) -> { return input + 1; };
        IntToIntFunction myF2 = (input) -> { return input + 1; };
        IntToIntFunction myF3 = (input) -> input + 1;
        IntToIntFunction myF4 = input -> input + 1;

        int[] a0 = ArrayMapper.map(n -> n + 1, myData);
        int[] a1 = ArrayMapper.map(myF1, myData);
        int[] a2 = ArrayMapper.map(myF2, myData);
        int[] a3 = ArrayMapper.map(myF3, myData);
        int[] a4 = ArrayMapper.map(myF4, myData);

        System.out.println(java.util.Arrays.toString(a0));
        System.out.println(java.util.Arrays.toString(a1));
        System.out.println(java.util.Arrays.toString(a2));
        System.out.println(java.util.Arrays.toString(a3));
        System.out.println(java.util.Arrays.toString(a4));
    }
}
