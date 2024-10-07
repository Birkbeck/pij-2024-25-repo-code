public class Example1 {
    public static void main(String[] args) {
        System.out.println("Given a series of words, each on a separate line,");
        System.out.println("this program finds the length of the longest word.");
        System.out.println("Please enter several sentences, one per line.");
        System.out.println("Finish with a blank line.");
        int maxi = 0;
        String word = ".";
        java.util.Scanner scan = new java.util.Scanner(System.in);
        while (word.length() > 0) {
            word = scan.nextLine();
            if (word.length() > maxi) {
                maxi = word.length();
            }
        }
        if (maxi == 0) {
            System.out.println("There were no words.");
        } else {
            System.out.println("The longest sentence was " + maxi + " characters long.");
        }
    }
}
