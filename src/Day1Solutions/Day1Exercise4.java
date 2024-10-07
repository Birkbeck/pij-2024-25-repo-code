public class Day1Exercise4 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Please enter a positive integer!");
        int input = scan.nextInt();

        // idea: if input is not divisible by any of the integers
        // from 2 to input - 1, then it must be prime; try them all!
        boolean primeRefuted = false;
        int i = 2;
        while (i < input) { // optimisation:    && !primeRefuted
            if (input % i == 0) { // i is a witness that input is not prime
                primeRefuted = true;
            }
            i = i + 1;
        }
        if (primeRefuted) {
            System.out.println("Your number is not prime!");
        } else {
            System.out.println("Your number is prime!");
        }
    }
}
