public class Mystery {

    static int compute(int input) {
        int result = 1;
        for (int i = 0;
             i < input;
             i++) { // slightly unusual layout of a for loop
            if (i % 2 == 1) {
                result++;
            } else {
                result += helper(i);
            }
        }
        return result;
    }

    static int helper(int x) {
        int r = 2*x + 1;
        return r;
    }

    public static void main(String[] args) {
        System.out.print("Hello! Please enter an int value: ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int input = sc.nextInt();
        int res = compute(input);
        System.out.println("Result: " + res);
    }
}
