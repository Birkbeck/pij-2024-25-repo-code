public class D3DoubleEquality {
    public static void main(String[] args) {
        double d1 = (0.1+0.1)/0.3;
        double d2 = 2.0* 1000.0/9000.0*3.0;
        // WRONG!
        if (d1 == d2) {
            // this is not printed due to rounding errors
            System.out.println("They are the same (wrong comparison)");
        }
        // RIGHT!
        if (Math.abs(d1 - d2) < 10E-6) {
            System.out.println("They are the same (right comparison)");
        }

    }
}
