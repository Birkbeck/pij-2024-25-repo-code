public class S3Example1 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Please key in a number: ");
        int num1 = scan.nextInt();
        System.out.print("And another: ");
        int num2 = scan.nextInt();
        if (num1 == num2) {
            System.out.println("They are the same.");
        }
    }
}
