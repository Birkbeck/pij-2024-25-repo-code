public class S4Example1 {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int num1, num2, num3, num4;
        
        System.out.println("Please key in four numbers: ");
        System.out.print("> ");
        num1 = scan.nextInt();
        System.out.print("> ");
        num2 = scan.nextInt();
        System.out.print("> ");
        num3 = scan.nextInt();
        System.out.print("> ");
        num4 = scan.nextInt();
        int total = num1 + num2 + num3 + num4;
        System.out.println("Total: " + total);
    }
}
