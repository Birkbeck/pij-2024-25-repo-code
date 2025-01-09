import java.util.Scanner;

public class Day3Exercise10 {
    public static void main(String[] args) {
        // Write a program that reads some text from the user and then says
        // how many letters ’e’ are there in that text.
        // Then modify the program so that it reads the text from the user
        // and then asks for a letter. The program should then say how many
        // times you can find the letter in the text.
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter some text!");
        String input = scan.nextLine();
        final boolean LET_USER_CHOOSE_LETTER = true; // set to false for initial version
        char letterToFind = 'e';
        if (LET_USER_CHOOSE_LETTER) {
            System.out.println("Please enter the letter to search for!");
            String letterInput = scan.nextLine();
            if (letterInput.isEmpty()) {
                System.out.println("Without a letter as input, we will just use 'e'.");
            } else {
                letterToFind = letterInput.charAt(0);
            }
        }
        int numberOfOccurrences = 0;
        int i = 0;
        while (i < input.length()) {
            if (letterToFind == input.charAt(i)) {
                numberOfOccurrences = numberOfOccurrences + 1;
            }
            i++;
        }
        System.out.println("We found " + numberOfOccurrences
                + " occurrences of '" + letterToFind + "' in your text!");
    }
}
