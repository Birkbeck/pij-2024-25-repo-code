import java.util.Scanner;

public class Day3Exercise3 {
    public static void main(String[] args) {
        // Write a program that reads two numbers from the user
        // and then offers a menu with the four basic
        // operations: addition, subtraction, multiplication,
        // and division. Once the user has selected an operation
        // from the menu, the calculator performs the operation.

        System.out.println("Please enter two numbers!");
        //java.util.Scanner scan = new java.util.Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        System.out.println("Please enter the operation symbol: +, -, *, or /");
        String operation = scan.next();
        double result = -1;
        // What if the real result is -1?
        // What if the user types the wrong symbol?
        boolean inputOkay = true;
        final String additionSymbol = "+"; // avoid "magic String"!
        switch (operation) {
            case additionSymbol:
                result = x + y;
                break;
            case "-": // we could use named variables/constants for the other operators too
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
                inputOkay = false;
                break;
        }
        //if (inputOkay) {
        //    System.out.println(result);
        //} else {
        //    System.out.println("I don't know the operation " + operation);
        //}
        // use conditional operator for the expression to print
        // instead of the if-else statement with two println instructions
        System.out.println(inputOkay ? result : "I don't know the operation " + operation);
    }
}
