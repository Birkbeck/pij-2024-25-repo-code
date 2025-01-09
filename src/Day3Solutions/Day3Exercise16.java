import java.util.Scanner;

public class Day3Exercise16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter some text: ");
        String originalInput = scan.nextLine();

        // generate input for the strict palindrome check from the
        // original input for the relaxed palindrome check, so
        // "Rise to vote, sir" becomes "risetovotesir".
        String input = "";
        int i = 0;
        while (i < originalInput.length()) {
            char ch = originalInput.charAt(i);
            if (Character.isLetter(ch)) {
                input = input + Character.toLowerCase(ch);
            }
            i++;
        }

        // Now we can reuse the code for the strict palindromes (with copy & paste
        // as a simple way of reuse; we will see better ways with methods soon).

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

        i = 0;
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

        // the output message is adapted to relaxed palindromes
        System.out.println("Your input \"" + originalInput + "\" is " +
                (isPalindrome ? "" : "not ") + "a relaxed palindrome!");
    }
}
