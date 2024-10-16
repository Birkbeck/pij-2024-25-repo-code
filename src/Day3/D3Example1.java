public class D3Example1 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Please choose an option:");
        System.out.println("For 'Checking you balance', please enter 1");
        System.out.println("For 'Purchases', please enter 2");
        System.out.println("For 'Refunds', please enter 3");
        System.out.println("For 'Queries about the warranty', please enter 4");
        System.out.println("For 'Returning faulty goods', please enter 5");
        System.out.println("For any other query, please enter 0");
        int choice = scan.nextInt();
        if (choice == 1) {
            // go and check balance
        } else if (choice == 2) {
            // go and purchase something
        } else if (choice == 3) {
            // go and process refunds
        } else if (choice == 4) {
            // go and answer queries
        } else if (choice == 5) {
            // return faulty goods
        } else {
            // go and talk with a human operator
        }
    }
}
