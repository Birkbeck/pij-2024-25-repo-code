public class Day1Exercise16 {
    public static void main(String[] args) {
        System.out.println("Tell me an integer number!");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int input = scan.nextInt();
        if (input <= 2) { // Easy case: the numbers up to the first prime, 2.
            System.out.println("The closest prime to your number is: " + 2);
        } else {
            // Our input may be prime itself. Then we are done. Otherwise,
            // we need to check, for i=1,2,3,..., if input - i and input + i
            // are prime. If at least one of them is prime, then we are done.
            // Otherwise we must try the next i.

            // Copy and paste from Exercise 4 for the prime check, several times...
            // we have not seen methods as /reusable/ program pieces yet, alas.
            boolean primeRefuted = false;
            int j = 2;
            while (j < input) {
                if (input % j == 0) { // j is a witness that input is not prime
                    primeRefuted = true;
                }
                j = j + 1;
            }
            int candSmaller = input;
            int candBigger = input;
            if (! primeRefuted) {
                System.out.println("The closest prime neighbour of your number is: " + input);
            } else {
                // We need to check all the values of i until we are done.
                boolean primeRefutedSmaller = false;
                boolean primeRefutedBigger = false;
                int i = 1; // distance from input
                boolean primeFound = false;
                while (! primeFound) {
                    // two more duplications of Exercise 4 follow
                    // (with renamings), alas
                    primeRefutedSmaller = false;
                    candSmaller = input - i;
                    j = 2;
                    while (j < candSmaller) {
                        if (candSmaller % j == 0) { // j is a witness that candSmaller is not prime
                            primeRefutedSmaller = true;
                        }
                        j = j + 1;
                    }
                    primeRefutedBigger = false;
                    candBigger = input + i;
                    j = 2;
                    while (j < candBigger) {
                        if (candBigger % j == 0) { // j is a witness that candBigger is not prime
                            primeRefutedBigger = true;
                        }
                        j = j + 1;
                    }
                    primeFound = (! primeRefutedSmaller) || (! primeRefutedBigger);
                    i = i + 1;
                }
                System.out.println("The closest prime neighbour(s) of your number:");
                if (! primeRefutedSmaller) {
                    System.out.println(candSmaller);
                }
                if (! primeRefutedBigger) {
                    System.out.println(candBigger);
                }
            }
        }
    }
}
