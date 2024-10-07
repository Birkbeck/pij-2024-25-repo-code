public class Day1Exercise8 {
    public static void main(String[] args) {
        System.out.println("Please enter zero or more positive integers,"
                + " -1 finishes.");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int input = 0; // initially not -1
        int maxi = -1;
        while (input != -1) {
            input = scan.nextInt();
            if (input > maxi) { // -1 is never greater than maxi
                maxi = input;
            }
        }
        System.out.println("Your highest number was " + maxi);
    }
}
