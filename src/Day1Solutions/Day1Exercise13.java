public class Day1Exercise13 {
    public static void main(String[] args) {
        // Almost the same as Ex 12, but with a different condition for
        // the outer loop and an explicit counter for how many primes
        // we have seen so far.

        int candidate = 2;
        int maxPrimeCount = 1000; // better: final int MAX_PRIME_COUNT = 1000;
        int primeCount = 0;
        while (primeCount < maxPrimeCount) {
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
                primeCount = primeCount + 1;
            }
            candidate = candidate + 1;
        }
    }
}
