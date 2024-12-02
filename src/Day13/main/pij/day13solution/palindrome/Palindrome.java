package pij.day13solution.palindrome;

public class Palindrome {
    public static boolean isPalindromeLoop(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        // base case: 0 or 1 letters
        if (s.length() <= 1) {
            return true;
        }
        // how can we handle a large string, say "abcba"?
        // s is a palindrome if the first and last letters
        // are the same and the rest of the string is
        // a palindrome
        // "abcba" -> 'a', "bcb", 'a'
        // "abcbz" -> 'a', ..., 'z'
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        if (first != last) {
            return false; // no need to check further
        }
        String rest = s.substring(1, s.length() - 1);
        return isPalindrome(rest);
    }
}
