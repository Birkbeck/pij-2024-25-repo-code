import java.util.Scanner;

public class Day3Exercise15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter some text: ");
        String input = scan.nextLine();

        // To make a palindrome, we take the original word and add its
        // "backward version" at the end. We can do the adding one character
        // at a time, starting at the last character and going backward.
        String result = input;

        int i = input.length() - 1; // the last character of input is here
        while (i >= 0) { // and the first character of input is at 0
            result = result + input.charAt(i);
            i--;
        }

        System.out.println(result);
    }
}
