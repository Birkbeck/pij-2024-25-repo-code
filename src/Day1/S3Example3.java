public class S3Example3 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Please key in your exam mark: ");
        int examMark = scan.nextInt();
        if (examMark >= 50) {
            System.out.println("A satisfactory result!");
        } else {
            System.out.println("Sorry, you have failed.");
        }
    }
}