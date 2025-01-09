import java.util.Scanner;

public class Day3Exercise12 {
    public static void main(String[] args) {
        // Write a program that reads a text from the user and then enter a
        // loop of requesting letters and counting them. The program stops
        // if the user asks for the same letter twice.
        Scanner scan = new Scanner(System.in);
        System.out.print("Please write a text: ");
        String input = scan.nextLine();

        // Now we need to keep track of the letters that have already been
        // counted so that we can detect a letter that has been requested
        // more than once. We are going to use a variable for this. Of the
        // data types that we have seen so far, the type String is perhaps
        // the most suitable: it can store multiple characters.

        String lettersCountedSoFar = ""; // nothing counted yet
        boolean repeatedLetterToCount = false;

        while (! repeatedLetterToCount) {
            System.out.print("Which letter would you like to count now? ");
            String letterInput = scan.nextLine();
            if (letterInput.isEmpty()) {
                System.out.println("Please enter at least one character (the first one will be used)!");
            } else {
                String letterToFindAsString = letterInput.substring(0, 1);
                if (lettersCountedSoFar.contains(letterToFindAsString)) {
                    // alternatively to method "contains", use an inner loop,
                    // similar to the one in the previous exercise
                    repeatedLetterToCount = true;
                } else {
                    char letterToFind = letterToFindAsString.charAt(0);
                    int numberOfOccurrences = 0;
                    int i = 0;
                    while (i < input.length()) {
                        if (letterToFind == input.charAt(i)) {
                            numberOfOccurrences = numberOfOccurrences + 1;
                        }
                        i++;
                    }
                    System.out.println("There are " + numberOfOccurrences + " in your text.");
                    lettersCountedSoFar = lettersCountedSoFar + letterToFindAsString;
                }
            }
        }
        System.out.println("Repeated character. Exiting the program...\n" +
                "Thank you for your cooperation. Good bye!");
    }
}
