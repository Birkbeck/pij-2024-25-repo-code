import java.util.Scanner;

public class Day3Exercise14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter some text: ");
        String input = scan.nextLine();

        // as long as we have no evidence to the contrary, assume that
        // the input is in fact a palindrome
        boolean isPalindrome = true;

        // idea for the check:
        // - "ABBA" is a palindrom because the first letter (at index 0) and
        // the last letter (at index 3 == length() - 1) are the same and
        // the second letter (at index 1) and the second-to-last letter
        // (at index 2 == length() - 2) are the same. We can stop incrementing
        // the index when we reach the middle of the word.
        // - words of odd length like "mum" have a "middle letter", but it
        // cannot affect the palindrome property

        int i = 0;
        // the loop would also work correctly as
        //   while (i < input.length() / 2) {
        //   while (i < input.length()) {
        // the version here avoids extra checks that do not change the result
        while (isPalindrome && i < input.length() / 2) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
            }
            i++;
        }

        System.out.println("Your input \"" + input + "\" is " +
                (isPalindrome ? "" : "not ") + "a strict palindrome!");
    }
}
