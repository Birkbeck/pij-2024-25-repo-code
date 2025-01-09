public class CalculatorDriver {
    public static void main(String[] args) {
        final int X = 8;
        final int Y = 3;
        Calculator calc = new Calculator();
        System.out.println("add(" + X + ", " + Y + ") = " + calc.add(X, Y));
        System.out.println("subtract(" + X + ", " + Y + ") = " + calc.subtract(X, Y));
        System.out.println("multiply(" + X + ", " + Y + ") = " + calc.multiply(X, Y));
        System.out.println("divide(" + X + ", " + Y + ") = " + calc.divide(X, Y));
        System.out.println("modulus(" + X + ", " + Y + ") = " + calc.modulus(X, Y));
    }
}
