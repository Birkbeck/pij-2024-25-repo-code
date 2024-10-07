public class Day1Exercise11b {
    public static void main(String[] args) {
        System.out.println("Please enter an integer between 1 and 25 (both included)!");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int n = scan.nextInt();
        if (n < 1 || n > 25) {
            System.out.println(n + " is not an integer between 1 and 25! Exiting...");
        } else {
            // for all i from 1 to n:
            // first print a lot of space, then print i times the number i,
            // with a suitable amount of space in between

            int i = 1;
            while (i <= n) {
                // 1. need to calculate what "a lot of space" means for given i and n
                // for n = 8 and i = 8, it is 0 spaces
                // for n = 8 and i = 7, it is 2 spaces
                // for n = 8 and i = 6, it is 4 spaces
                // ...
                // for n = 8          , it is 2*(n-i) spaces
                // observation: the value of n does not matter, as long as it has 1 digit
                // for n < 10         , it is 2*(n-i) spaces
                String initialSpace = "";
                if (n < 10) {
                    // build up String of 2*(n-i) spaces
                    int j = 0;
                    while (j < 2*(n-i)) {
                        initialSpace = initialSpace + " ";
                        j = j + 1;
                    }
                    // shorter alternative: initialSpace = " ".repeat(2*(n-i));
                } else {
                    // assumption: we want numbers with 1 digit and with
                    // 2 digits to be properly aligned with each other,
                    // e.g., for n == 10:
                    //                           ...
                    //     9  9  9  9  9  9  9  9  9
                    // 10 10 10 10 10 10 10 10 10 10
                    //
                    // need 3*(n-i) spaces initially for that
                    // build up String of 3*(n-i) spaces
                    int j = 0;
                    while (j < 3*(n-i)) {
                        initialSpace = initialSpace + " ";
                        j = j + 1;
                    }
                    // shorter alternative: initialSpace = " ".repeat(3*(n-i));
                }
                // 2. After the initial space block, we need i times the number i
                //    (if n >= 10 and i < 10 with an extra space in front) separated by a space
                String secondPart = "";
                int j = 0;
                while (j < i) {
                    if (n >= 10 && i < 10) {
                        secondPart = secondPart + " ";
                    }
                    secondPart = secondPart + i; // append the number
                    if (j != n-1) { // no separator space in the last round
                        secondPart = secondPart + " ";
                    }
                    j = j + 1;
                }
                System.out.println(initialSpace + secondPart);
                i = i + 1;
            }
        }
    }
}
