package pij.day13solution.palindrome;

public class PalindromeDriver {
    public static void main(String[] args) {
        String input = "abcba";
        boolean expected = true;
        boolean actualRec = Palindrome.isPalindrome(input);
        boolean actualLoop = Palindrome.isPalindromeLoop(input);
        System.out.println("Input:            " + input);
        System.out.println("Expected:         " + expected);
        System.out.println("Actual recursive: " + actualRec);
        System.out.println("Actual with loop: " + actualLoop);
    }
}
