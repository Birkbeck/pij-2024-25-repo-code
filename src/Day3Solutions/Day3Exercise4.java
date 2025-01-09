import java.util.Scanner;

public class Day3Exercise4 {
    public static void main(String[] args) {
        // Write a program that reads a text representing a mathematical
        // operation (one of the four basic ones) with two operands, and
        // then executes it. For example, if the user enters “3/5” the
        // program outputs “0.6”; if the user enters “23 * 4” the program
        // outputs “92”.
        System.out.println("Please enter a mathematical operation (+, -, *, /) with its arguments)!");
        System.out.println("Examples: 3/5 or 23 * 4");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        // we got the input... now find the operator
        final char PLUS = '+';
        final char MINUS = '-';
        final char TIMES = '*';
        final char DIVIDE = '/';
        final char NONE = 'n'; // initially none of the supported operators
        char operator = NONE;

        // find the position of the operator symbol to "split" the input
        int operatorPosition = -1;
        int i = 0;
        boolean foundAnOperator = false;
        while (i < input.length() && ! foundAnOperator) {
            char ch = input.charAt(i);
            if (ch == PLUS || ch == MINUS || ch == TIMES || ch == DIVIDE) {
                operatorPosition = i;
                operator = ch;
                foundAnOperator = true;
            } else {
                i++;
            }
        }

        if (! foundAnOperator) {
            System.out.println("Unable to proceed, found no operator in input: " + input);
        } else {
            // We have the operator, and we know where it is. So if the input
            // is legitimate, the rest before and after the operator's position
            // must be the two numbers to process.
            String first = input.substring(0, operatorPosition);
            String second = input.substring(operatorPosition + 1);
            double x = Double.parseDouble(first);
            double y = Double.parseDouble(second);

            double result = -1;
            switch (operator) {
                case PLUS:
                    result = x + y;
                    break;
                case MINUS:
                    result = x - y;
                    break;
                case TIMES:
                    result = x * y;
                    break;
                case DIVIDE:
                    result = x / y;
                    break;
                default:
                    // this case should not be reachable due to the earlier
                    // checks on the operator; we will later learn how we
                    // can check this at runtime (using exceptions)
                    break;
            }
            System.out.println(result);
        }
    }
}
