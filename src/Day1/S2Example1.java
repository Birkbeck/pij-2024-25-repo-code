public class S2Example1 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Please introduce a number: ");
        String word = scan.nextLine();
        int n = Integer.parseInt(word);
        System.out.println("The number was " + n);
        System.out.println("The next number is " + (n + 1));
    }
}
