public class Calculator {
    public double add(int x, int y) {
        // convert x to double so that addition for type double is used
        // and the result of two billion plus two billion is approx.
        // four billion, not a negative number
        return (double)x + y;
    }

    public double subtract(int x, int y) {
        // note that +, -, ... with a double and an int will automatically
        // convert the int to a double and do the operation for double, so
        // it suffices to convert just one of the two explicitly
        return (double)x - y;
    }

    public double multiply(int x, int y) {
        return (double)x * y;
    }

    public double divide(int x, int y) {
        return (double)x / y;
    }

    public double modulus(int x, int y) {
        return (double)x % y;
    }
}
