import java.util.Scanner;

public class Day3Exercise17 {
    public static void main(String[] args) {
        // Write a program that reads a number with commas and decimal dots
        // (such as “23,419.34”) and then prints a number that is half of it.
        // Do not use Double.parseDouble() or nextDouble() from class
        // java.util.Scanner.
        // If you were writing a simple spreadsheet, you could use this code
        // to parse the input in the cells.
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number with commas and decimal dots, such as 23,419.34!");
        String input = scan.nextLine();

        final char DOT = '.';
        final char COMMA = ',';

        // ignore the commas in the input, use the decimal dot (if any)
        // to split between integer part and the decimal fraction
        // between 0 (included) and 1 (excluded)

        String beforeTheDot = "";
        String afterTheDot = "";

        // extract the digits before and after the dot separately;
        // ignore the commas
        int i = 0;
        boolean dotSeen = false; // tells us whether the digits are before or after the dot
        while (i < input.length()) {
            char ch = input.charAt(i);
            if (ch != COMMA) {
                if (ch == DOT) {
                    dotSeen = true;
                } else if (dotSeen) {
                    afterTheDot = afterTheDot + ch;
                } else {
                    beforeTheDot = beforeTheDot + ch;
                }
            }
            i++;
        }

        // if the user made a correct input, we now have two int values
        // as Strings

        // Some examples will help us see more clearly how to proceed:

        // - both the number before the dot and the number after the dot are even
        // 8.6 / 2 gives 4.3
        // 4.8 / 2 gives 2.4
        // -> we can divide both numbers by 2 individually ...
        // 8.006 / 2 gives 4.003
        // -> ... and we need to copy the leading zeros after the dot
        //    (also in the other cases)

        // - the number before the dot is even, but the number after the dot is odd
        // 8.7 / 2 gives 4.35
        // 2.1 / 2 gives 1.05
        //  -> we can divide both numbers by 2 individually, but we must print
        //     an extra "5" at the very end

        // - the number before the dot is odd and the number after the dot is even
        // 0.8 / 2    gives 0.4,    but 5.8 / 2    gives 2.9
        // 0.0008 / 2 gives 0.0004, but 5.0008 / 2 gives 2.5004
        //  -> we can divide both numbers by 2 individually, but we must add
        //     the equivalent of 0.5 to the result of the second one

        // - the number before the dot is odd and the number after the dot is odd
        // 0.9 / 2    gives 0.45
        // 5.9 / 2    gives 2.95
        // 0.0009 / 2 gives 0.00045
        // 5.0009 / 2 gives 2.50045

        // So, we need to determine the number of leading zeros after the dot.
        int numberOfLeadingZerosAfterDot = 0;
        i = 0;
        while (i < afterTheDot.length()) {
            if (afterTheDot.charAt(i) == '0') {
                numberOfLeadingZerosAfterDot++;
            }
            i++;
        }

        int before = Integer.parseInt(beforeTheDot);
        int beforeHalf = before / 2;
        boolean addZeroPointFiveToResult = before % 2 != 0; // 3.2 / 2 gives 1.6, not 1.1

        // we need the special case for inputs like 3.0, where nothing follows
        // after the zeros that are after the dot
        int after = numberOfLeadingZerosAfterDot == afterTheDot.length() ?
                0 : // if nothing follows the zeros, it's zero
                Integer.parseInt(afterTheDot); // works also with leading zeros
        int afterHalf = after / 2;
        boolean appendFiveToResult = after % 2 != 0; // 0.3 / 2 gives 0.15, not 0.1

        String afterHalfAsString = "" + afterHalf; // "" + ... converts /anything/ to a String

        String toPrint = beforeHalf + ".";
        // the next character will depend on whether we must add 0.5

        if (numberOfLeadingZerosAfterDot > 0) {
            toPrint = toPrint + (addZeroPointFiveToResult ? "5" : "0");
            i = 1; // (!)
            while (i < numberOfLeadingZerosAfterDot) {
                toPrint = toPrint + "0";
                i++;
            }
            toPrint = toPrint + afterHalfAsString;
        } else if (addZeroPointFiveToResult) {
            // there is no leading zero, and we must add 5 to the digit right after the dot
            char firstDigitOfAfterHalf = afterHalfAsString.charAt(0);
            char digitToPrint;
            switch (firstDigitOfAfterHalf) {
                // Dividing an int number by 2 will set its last digit to
                // 0, 1, 2, 3, or 4.
                case '0':
                    digitToPrint = '5';
                    break;
                case '1':
                    digitToPrint = '6';
                    break;
                case '2':
                    digitToPrint = '7';
                    break;
                case '3':
                    digitToPrint = '8';
                    break;
                case '4':
                    digitToPrint = '9';
                    break;
                default:
                    // That's unexpected... if this line is reached by the
                    // running program, it means that we have made a
                    // programming error. We don't know yet how to handle
                    // such issues properly, so for now indicate to the user
                    // by the output that something has gone wrong.
                    digitToPrint = 'X';
                    break;
            }
            // Instead of the switch statement, we could also use
            //   Integer.parseInt(afterHalfAsString.substring(0, 1)) + 5
            // to get the first digit to print after the dot

            toPrint = toPrint + digitToPrint;

            // take care to omit the first character!
            //   here afterHalfAsString.substring(1) is a shortcut for
            //   afterHalfAsString.substring(1, afterHalfAsString.length())
            toPrint = toPrint + afterHalfAsString.substring(1);
        } else {
            // no leading zero, no need to add 0.5
            toPrint = toPrint + afterHalfAsString;
        }

        if (appendFiveToResult) { // 3.7 / 2 gives 1.85, we must add the final "5"
            toPrint = toPrint + "5";
        }

        // The spec didn't say whether to put in the commas as separators again,
        // (11709.67 vs 11,709.67), so we omit them for simplicity.
        System.out.println(toPrint);

        // This program had several more or less independent parts that we
        // have written down one after the other into one rather long
        // sequence of instructions. We will soon see how we can split
        // a program into separate pieces that we can _read more easily_
        // and _reuse_ by writing methods.
    }
}
