import java.util.Scanner;

public class Day3Exercise13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the total cost of the purchase (in pence): ");
        int penceTotalCost = scan.nextInt();
        System.out.print("Please enter the amount of money that was paid (in pence): ");
        int pencePaid = scan.nextInt();

        // some "final" variables (aka constants) for the available denominations
        final int PENCE5000 = 5000; // GBP 50
        final int PENCE2000 = 2000; // GBP 20
        final int PENCE1000 = 1000; // GBP 10
        final int PENCE500 = 500; // GBP 5
        final int PENCE200 = 200; // GBP 2
        final int PENCE100 = 100; // GBP 1
        final int PENCE50 = 50; // GBP 0.50
        final int PENCE20 = 20; // GBP 0.20
        final int PENCE10 = 10; // GBP 0.10
        final int PENCE5 = 5; // GBP 0.05
        final int PENCE2 = 2; // GBP 0.02
        final int PENCE1 = 1; // GBP 0.01

        int penceToReturn = pencePaid - penceTotalCost;

        if (penceToReturn < 0) {
            System.out.println("It seems that not enough was paid to cover the total cost!");
        }

        // these variables shall hold the result information
        int pence5000Change = 0;
        int pence2000Change = 0;
        int pence1000Change = 0;
        int pence500Change = 0;
        int pence200Change = 0;
        int pence100Change = 0;
        int pence50Change = 0;
        int pence20Change = 0;
        int pence10Change = 0;
        int pence5Change = 0;
        int pence2Change = 0;
        int pence1Change = 0;

        // try to use the next-highest denomination as long as possible
        // (we assume that we have enough of each denomination)
        while (penceToReturn >= PENCE5000) {
            penceToReturn -= PENCE5000;
            pence5000Change++;
        }

        while (penceToReturn >= PENCE2000) {
            penceToReturn -= PENCE2000;
            pence2000Change++;
        }

        while (penceToReturn >= PENCE1000) {
            penceToReturn -= PENCE1000;
            pence1000Change++;
        }

        while (penceToReturn >= PENCE500) {
            penceToReturn -= PENCE500;
            pence500Change++;
        }

        while (penceToReturn >= PENCE200) {
            penceToReturn -= PENCE200;
            pence200Change++;
        }

        while (penceToReturn >= PENCE100) {
            penceToReturn -= PENCE100;
            pence100Change++;
        }

        while (penceToReturn >= PENCE50) {
            penceToReturn -= PENCE50;
            pence50Change++;
        }

        while (penceToReturn >= PENCE20) {
            penceToReturn -= PENCE20;
            pence20Change++;
        }

        while (penceToReturn >= PENCE10) {
            penceToReturn -= PENCE10;
            pence10Change++;
        }

        while (penceToReturn >= PENCE5) {
            penceToReturn -= PENCE5;
            pence5Change++;
        }

        while (penceToReturn >= PENCE2) {
            penceToReturn -= PENCE2;
            pence2Change++;
        }

        while (penceToReturn >= PENCE1) {
            penceToReturn -= PENCE1;
            pence1Change++;
        }

        System.out.println("You get the following change:\n" +
                pence5000Change + " 50-pound notes,\n" +
                pence2000Change + " 20-pound notes,\n" +
                pence1000Change + " 10-pound notes,\n" +
                pence500Change + " 5-pound notes,\n" +
                pence200Change + " 2-pound coins,\n" +
                pence100Change + " 1-pound coins,\n" +
                pence50Change + " 50-pence coins,\n" +
                pence20Change + " 20-pence coins,\n" +
                pence10Change + " 10-pence coins,\n" +
                pence5Change + " 5-pence coins,\n" +
                pence2Change + " 2-pence coins,\n" +
                pence1Change + " 1-pence coins.");
    }
}
