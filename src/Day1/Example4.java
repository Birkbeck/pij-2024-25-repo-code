public class Example4 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String word;
        System.out.print("Please key in a word: ");
        word = scan.nextLine();
        System.out.println("The word was: " + word);
        System.out.print("Now please key in another: ");
        word = scan.nextLine();
        System.out.println("And this one was: " + word);
    }
}
