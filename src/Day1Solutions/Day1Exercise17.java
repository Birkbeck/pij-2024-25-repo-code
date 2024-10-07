public class Day1Exercise17 {
    public static void main(String[] args) {
        // Some variables for the "special mission" to find the smallest
        // number of addends so that the sum of these addends gets the
        // first 3 or 10 digits of pi right (here interpreted in the
        // sense of the String representation rather than using rounding)
        String firstThreeDigits = "3.14";
        String firstTenDigits = "3.141592653";
        // Variables to tell us: for which number of addends were the
        // first three or ten digits correct for the first time?
        // Here -1 is a "sentinel value" to tell us: the first
        // three ot ten digits were never correct.
        int sentinel = -1; // better: final int SENTINEL = -1;
        int threeDigitsCorrectHereFirst = sentinel;
        int tenDigitsCorrectHereFirst = sentinel;

        // Here the main part of the program begins!
        System.out.println("Please enter the number of addends:");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int n = scan.nextInt();
        double sum = 0; // nothing there yet
        int signFactor = 1; // to be multiplied with addend, initially -1^0
        int k = 0; // index of the current addend; denominator will be 2k + 1
        while (k < n) {
            // note: 4.0 is a double, but 4 would be int, leading to integer division
            double addend = 4.0 / (2*k + 1);
            addend = addend * signFactor;
            sum = sum + addend;
            String sumAsString = "" + sum;

            // are we still looking for the solution?
            if (threeDigitsCorrectHereFirst == sentinel
                    // does the current sum have at least 4 characters
                    // (including the decimal point)?
                    && sumAsString.length() >= 4
                    // are the first 3 digits (with the decimal point)
                    // the same as the ones in pi?
                    && firstThreeDigits.equals(sumAsString.substring(0, 4))) {

                // note: Strings need to be compared for being equal by the
                // .equals() method; the operator == does not compare String
                // contents, but memory addresses (which is not what we want)!
                threeDigitsCorrectHereFirst = k+1; // in round k, we have added k+1 addends at this point
            }
            // analogously for the first 10 digits
            if (tenDigitsCorrectHereFirst == sentinel
                    && sumAsString.length() >= 11
                    && firstTenDigits.equals(sumAsString.substring(0, 11))) {
                tenDigitsCorrectHereFirst = k+1;
            }

            signFactor = -signFactor; // toggle between 1 and -1
            k = k + 1;
        }
        System.out.println("The sum of the first " + n + " addends is: " +sum);
        if (threeDigitsCorrectHereFirst == sentinel) {
            System.out.println("The first three digits were never correct.");
        } else {
            System.out.println("The first three digits were first correct with "
                    + threeDigitsCorrectHereFirst); // 119
        }
        if (tenDigitsCorrectHereFirst == sentinel) {
            System.out.println("The first ten digits were never correct.");
        } else {
            System.out.println("The first ten digits were first correct with "
                    + tenDigitsCorrectHereFirst); // 1362989306
        }
    }
}
