public class ArrayCheckerDriver {

    private static String arrayToString(int[] a) {
        // alternative: use method java.util.Arrays.toString(int[])
        String result = "[";
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + a[i];
        }
        result = result + "]";
        return result;
    }

    private static void process(int[] a) {
        ArrayChecker checker = new ArrayChecker();
        String aString = arrayToString(a);
        System.out.println("Your array is: " + aString);
        if (checker.isSymmetrical(a)) {
            System.out.println("It is symmetrical.");
        } else {
            int[] aReversed = checker.reverse(a);
            String aReversedString = arrayToString(aReversed);
            System.out.println("It is not symmetrical. The reversed array is: " +
                    aReversedString);
        }
    }

    public static void main(String[] args) {
        int[] a1 = { 1, 8, 8, 1 };
        int[] a2 = { 2, 3, 2 };
        int[] a3 = { 9 }; // all arrays of length 1 are symmetrical
        int[] a4 = { }; // the empty array is symmetrical
        int[] b1 = { 2, 8, 8, 1 };
        int[] b2 = { 2, 3, 4 };
        int[] b3 = { 2, 8, 9, 8, 8, 2 };
        int[] b4 = { 2, 1, 3, 3, 0, 4 };

        // we can make an array of arrays and then go through it with a for loop
        int[][] arrayOfArrays = { a1, a2, a3, a4, b1, b2, b3, b4 };
        for (int i = 0; i < arrayOfArrays.length; i++) {
            // check and (potentially) reverse each array on its own
            process(arrayOfArrays[i]);
        }
    }
}
