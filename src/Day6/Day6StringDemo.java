public class Day6StringDemo {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String str1 = scan.nextLine();
        System.out.print("Enter another string: ");
        String str2 = scan.nextLine();

        System.out.println("Are '" + str1 + "' and '"
                + str2 + "' the same?");

        System.out.println("Using ==: " + (str1 == str2));

        System.out.println("Using .equals(): " + (str1.equals(str2)));
    }
}
