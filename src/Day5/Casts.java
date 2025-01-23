public class Casts {
    public static void runDoubleToInt1() {
        double d = 1.0;
        int i = (int) d; // puts 1 into i (not 1.0)
        System.out.println(i);
    }

    public static void runDoubleToInt2() {
        double d = 1.8;
        int i = (int) d; // puts 1 into i (no rounding by the cast!)
        System.out.println(i);
    }

    public static void runIntToDouble() {
        int i = 1;
        double d = i; // puts 1.0 into d (not 1)
        System.out.println(d);
    }

    public static void runDivideExample() {
        int i = 3;
        int j = 4;
        System.out.println(i + "/" + j + " is about " + (i/(double)j));
    }

    public static void main(String[] args) {
        runDoubleToInt1();
        runDoubleToInt2();
        runIntToDouble();
        runDivideExample();
    }
}
