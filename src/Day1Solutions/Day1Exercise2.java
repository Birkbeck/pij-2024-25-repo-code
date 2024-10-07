public class Day1Exercise2 {
    public static void main(String[] args) {
        // The first number, i, that the user enters determines the maximum
        // number of following numbers that the user may enter as 10 - i
        // (if that value is not positive, we read no more numbers).
        // For each of the following numbers, j, that the user enters:
        // - If j is 0, the program immediately stops reading numbers.
        // - If j is 1, nothing happens.
        // - For all other values, the number is echoed back to the user.
        // When number reading has ended, the program prints "finished"
        // and terminates (i.e., it stops).
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int i = scan.nextInt();
        while (i < 10) {
            i = i + 1;
            int j = scan.nextInt();
            if (j == 0) {
                break;
            } else if (j != 1) {
                System.out.println(j);
            }
        }
        System.out.println("finished");
    }
}
