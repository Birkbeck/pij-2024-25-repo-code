package pij.day10;
public class SomeExample {

    /**
     * Returns the sum of the lengths of the non-null entries in strings.
     *
     * @param strings must not be null, but may contain null
     * @return the sum of the lengths of the non-null entries in strings
     * @throws NullPointerException if strings is the null reference
     */
    public static int sumLengths(String[] strings) {
        int result = 0;
        for (String s : strings) {
            result += s.length();
        }
        return result;
    }

    /**
     * Computes and prints the sum of the lengths of the non-null entries in
     * words.
     *
     * @param words must not be null, but may contain null
     * @throws NullPointerException if words is the null reference
     */
    public static void process(String[] words) {
        int sum = sumLengths(words);
        System.out.println("The sum of the lengths is " + sum);
    }

    public static void main(String[] args) {
        String[] myWords = new String[3];
        myWords[0] = "Hello";
        myWords[1] = null; // myWords /contains/ the null reference
        myWords[2] = "World";
        process(myWords);
        System.out.println("Take 2.");
        String[] noWords = null; // noWords /is/ the null reference
        process(noWords);
        System.out.println("Bye!");
    }
}
