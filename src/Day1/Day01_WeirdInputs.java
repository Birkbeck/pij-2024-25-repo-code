public class Day01_WeirdInputs {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer number and press Return!");
        int num = scan.nextInt();
        System.out.println("Please enter a String and press Return!");
        String word1 = scan.nextLine();
        System.out.println("Please enter another String and press Return!");
        String word2 = scan.nextLine();
        System.out.println("Your number was " + num
                           + ", your first String was " + word1
                           + ", and your second String was " + word2 + ".");
    }
}
