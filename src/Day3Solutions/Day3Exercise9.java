import java.util.Scanner;

public class Day3Exercise9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // First tell the user what they are supposed to do and read their input
        System.out.println("Please enter some text!");
        String input = scan.nextLine();

        System.out.println("*** Your input, one character per line ***");
        // Now we can print the input, one character at a time
        int i = 0;
        while (i < input.length()) {
            System.out.println(input.charAt(i));
            i++;
        }

        System.out.println("*** Your input, one word per line ***");
        i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                System.out.println();
            } else {
                System.out.print(ch);
            }
            i++;
        }
        System.out.println(); // after the last word, go to a new line
    }
}
