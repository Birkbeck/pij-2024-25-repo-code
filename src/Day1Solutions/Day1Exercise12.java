public class Day1Exercise12 {
    public static void main(String[] args) {
        int candidate = 2;
        int maxCandidate = 1000; // better: final int MAX_CANDIDATE = 1000;
        while (candidate < maxCandidate) {
            // idea: if candidate is not divisible by any of the integers
            // from 2 to input - 1, then it must be prime; try them all!
            boolean primeRefuted = false;
            int i = 2;
            while (i < candidate) {
                if (candidate % i == 0) { // i is a witness that candidate is not prime
                    primeRefuted = true;
                }
                i = i + 1;
            }
            if (! primeRefuted) {
                System.out.println(candidate);
            }
            candidate = candidate + 1;
        }
    }
}
