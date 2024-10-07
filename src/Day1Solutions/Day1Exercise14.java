public class Day1Exercise14 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int numberToGuess = (int) Math.round(1000 * Math.random());
        System.out.println("Try to guess my number!");
        int numberOfGuesses = 0;
        boolean correct = false; // initially no guess yet, so no correct guess
        while (! correct) {
            System.out.print("Tell me a number: ");
            int guessedNumber = scan.nextInt();
            numberOfGuesses = numberOfGuesses + 1;
            if (guessedNumber < numberToGuess) {
                System.out.println("No! My number is higher.");
            } else if (guessedNumber > numberToGuess) {
                System.out.println("No! My number is lower.");
            } else {
                correct = true;
                System.out.println("CORRECT!");
            }
        }
        System.out.println("You needed " + numberOfGuesses + " guesses.");
    }
}
