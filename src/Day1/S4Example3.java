public class S4Example3 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int total = 0;
        boolean finished = false;
        while (!finished) {
            System.out.println("Please enter a number (end with 0):");
            int num = scan.nextInt();
            if (num != 0) {
                total = total + num;
            } else {
                finished = true;
            }
        }
        System.out.println("Total is " + total);
    }
}
