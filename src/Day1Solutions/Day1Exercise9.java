public class Day1Exercise9 {
    public static void main(String[] args) {
        System.out.println("Please enter zero or more positive integers,"
                + " -1 finishes.");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int input = 0; // initially not -1
        int previous = -1;
        boolean consecutiveAndIncreasing = true; // no counterexample yet
        while (input != -1) {
            input = scan.nextInt();
            if (previous != -1 // the first value is always okay
                    && input != -1 // input is not the end-of-loop signal
                    && input != previous + 1) { // not a consecutive increase
                consecutiveAndIncreasing = false; // counterexample found!
            }
            previous = input;
        }
        if (consecutiveAndIncreasing) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
