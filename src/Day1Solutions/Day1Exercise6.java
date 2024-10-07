public class Day1Exercise6 {
    public static void main(String[] args) {
        System.out.println("Please enter two positive integers to divide!");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int xOrig = x; // the initial value of x will be needed at the end
                       // for output to the user

        // Division can be expressed as repeated subtraction:
        //   x / y = 1 + ((x-y) / y)
        // If x is smaller than y, we are done.
        int result = 0;
        while (x >= y) {
            result = result + 1;
            x = x - y;
        }
        int remainder = x;
        System.out.println(xOrig + " divided by " + y + " gives " + result
                + ", remainder " + remainder);
    }
}
