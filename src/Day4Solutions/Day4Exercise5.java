import java.util.Scanner;

public class Day4Exercise5 {

    static int hexaDigit2Decimal(char hexaDigit) {
        switch (hexaDigit) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'a':
                return 10;
            case 'b':
                return 11;
            case 'c':
                return 12;
            case 'd':
                return 13;
            case 'e':
                return 14;
            case 'f':
                return 15;
            default:
                return -1;
        }
    }

    static char decimal2hexaDigit(int decimal) {
        switch (decimal) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'a';
            case 11:
                return 'b';
            case 12:
                return 'c';
            case 13:
                return 'd';
            case 14:
                return 'e';
            case 15:
                return 'f';
            default:
                return '!';
        }
    }

    static int hexadecimal2decimal(String hexadecimal) {
        final String HEXADECIMAL_PREFIX = "0x";
        int result = 0;
        int powerOf16 = 1;
        for (int i = hexadecimal.length() - 1; i >= HEXADECIMAL_PREFIX.length(); i--) {
            char hexaDigit = hexadecimal.charAt(i);
            int factor = hexaDigit2Decimal(hexaDigit);
            result += factor * powerOf16;
            powerOf16 *= 16;
        }
        return result;
    }

    static String decimal2hexadecimal(int decimal) {
        final String HEXADECIMAL_PREFIX = "0x";
        if (decimal < 0) {
            // returning a strange result for unsupported method parameter
            // values is not ideal... when we learn about exceptions, we
            // will see a better way
            return "Only non-negative numbers are supported!";
        }

        if (decimal == 0) {
            // special case: "0x0" rather than "0x"
            return HEXADECIMAL_PREFIX + "0";
        }

        // still here? then decimal must be > 0

        String result = "";
        // while we haven't transformed everything yet...
        while (decimal > 0) {
            // what is the last hexadecimal digit for the remaining decimal?
            char hexDigit = decimal2hexaDigit(decimal % 16);
            result = hexDigit + result;

            // now remove that last hexadecimal digit from decimal, whatever it was
            decimal /= 16;
        }

        return HEXADECIMAL_PREFIX + result;
    }

    public static void main(String[] args) {
        System.out.print("Please type a decimal or hexadecimal number: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        boolean hexadecimalInput = input.length() >= 2 &&
                input.charAt(0) == '0' &&
                input.charAt(1) == 'x';

        if (hexadecimalInput) {
            int decimal = hexadecimal2decimal(input);
            System.out.println("The decimal value is: " + decimal);
        } else {
            int decimal = Integer.parseInt(input);
            String hexadecimal = decimal2hexadecimal(decimal);
            System.out.println("The hexadecimal value is: " + hexadecimal);
        }
    }
}
