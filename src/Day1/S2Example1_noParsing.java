public class S2Example1_noParsing {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Please introduce a number: ");
        String word = scan.nextLine();
        System.out.println("The number was " + word);
        System.out.println("The next number is " + (word + 1));
    }
}
