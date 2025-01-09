import java.util.Scanner;

public class Day3Exercise11 {
    public static void main(String[] args) {
        // Write a program that reads a short string and then some longer text.
        // The program must say how many times you can find the short string
        // in the text. You cannot use any method of String apart from charAt()
        // and length().
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a short string!");
        String shortString = scan.nextLine();
        System.out.println("Please enter some longer text!");
        String longerText = scan.nextLine();
        int numberOfOccurrences = 0;

        // strategy: from each of the possible starting points of shortString
        // in longerText, compare the characters of shortString with those
        // in longerText from the starting point
        // example:
        // for longerText = "ababa" (length 5) and shortString = "aba" (length 3),
        // check from starting points 0, 1, and 2 (leads to finding 2 occurrences)

        int startingPoint = 0;
        while (startingPoint + shortString.length() <= longerText.length()) {
            // now let's compare the chars one by one and see if one pair
            // of them is _not_ equal

            // OPTION 1
            /*
            boolean charsSoFarAreEqual = true;
            int shortStringIndex = 0;

            // the loop would work as intended also without the part of the
            // condition before the "&&" (why?)
            while (charsSoFarAreEqual && shortStringIndex < shortString.length()) {
                if (shortString.charAt(shortStringIndex) != longerText.charAt(startingPoint + shortStringIndex)) {
                    charsSoFarAreEqual = false;
                }
                shortStringIndex++;
            }
            if (charsSoFarAreEqual) { // all chars must have been equal!
                numberOfOccurrences++;
            }
            */

            // OPTION 2 (less writing effort)

            String longerStringPrefix = longerText.substring(startingPoint, startingPoint + shortString.length());
            if (shortString.equals(longerStringPrefix)) {
                numberOfOccurrences++;
            }

            startingPoint++;
        }
        System.out.println("We found " + numberOfOccurrences +
                " occurrences of \"" + shortString + "\" in your text!");
    }
}
