public class ArrayChecker {
    // a method that returns true if the array of int provided as argument is
    // symmetrical and false otherwise. An array is symmetrical if the element
    // at [0] is the same as the element at [length-1], the element at [1] is
    // the same as the element at [length-2], etc.
    public boolean isSymmetrical(int[] a) {
        // idea: check all possible pairs of entries that must be the same for
        // the whole array to be symmetrical; if a single pair does not have
        // the same value, we know that the array cannot be symmetrical
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] != a[a.length - i - 1]) {
                // it suffices to do this check for i at most a.length/2 - 1
                // because:
                // - a[i] != a[a.length - i - 1] has the same result as
                //   a[a.length - i - 1] != a[i]
                //   (so a[1] != a[4] has the same result as a[4] != a[1],
                //   and we don't need the second check)
                // - if a.length is an odd number, the check
                //   a[i] != a[a.length - i - 1] always evaluates to false for
                //   i = a.length / 2 because we would be comparing the "middle
                //   element" of the array with itself
                return false;
            }
        }
        // still not returned? then all pairs of entries checked in the loop
        // must have been symmetrical
        return true;
    }

    // a method that takes an array of int and returns another array of int
    // of the same size and with the same numbers, but in opposite order.
    // The method should not modify the contents of the input array.
    public int[] reverse(int[] a) {
        // we want to return /another/ array of the /same size/ ...
        int[] result = new int[a.length];

        // ... and now we need to fill in the numbers from the method parameter
        // in the opposite order
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - i - 1];
            // alternative to the previous line that works equally well:
            //result[a.length - i - 1] = a[i];
        }
        return result;
    }
}
