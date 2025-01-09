/**
 * This program reads the user's year of birth as an integer from the keyboard
 * and prints whether the user is (more precisely, was in 2024) an adult,
 * using an age of 18 years as the threshold.
 */
public class Day3Exercise1 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int currentYear = 2024;
        System.out.print("When were you born (year)? ");
        int birthYear = scanner.nextInt();
        int ageAprox = currentYear - birthYear;
        String result = (ageAprox > 17) ? "" : "not ";
        System.out.println("It seems you are " + result + "an adult.");
    }
}
