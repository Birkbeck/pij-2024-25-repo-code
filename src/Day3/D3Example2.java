public class D3Example2 {
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
        switch (choice) {
            case 1:
                // go and check balance
                break;
            case 2:
                // go and purchase something
                break;
            case 3:
                // go and process refunds
                break;
            case 4:
                // go and answer queries
                break;
            case 5:
                // return faulty goods
                break;
            default:
                // go and talk with a human operator
                break;
        }
    }
}
