public class DoublePointTester {

    // helper method
    static void print(DoublePoint p1, DoublePoint p2) {
        System.out.println("p1 = (" + p1.x + ", " + p1.y + "); p2 = (" + p2.x + ", " + p2.y + ")");
    }

    // helper method (overloading the name "print")
    static void print(DoublePoint p1, DoublePoint p2, DoublePoint p3) {
        System.out.println("p1 = (" + p1.x + ", " + p1.y + "); p2 = (" + p2.x + ", " + p2.y + ")" +
                "; p3 = (" + p3.x + ", " + p3.y + ")");
    }

    public static void main(String[] args) {
        DoublePoint p1 = new DoublePoint();
        p1.x = 2;
        p1.y = 3;
        DoublePoint p2 = new DoublePoint();
        p2.x = 5;
        p2.y = 7;
        print(p1, p2);
        System.out.println("Distance p1 to p2: " + p1.distanceTo(p2));
        System.out.println("Distance p2 to p1: " + p2.distanceTo(p1));
        System.out.println("Distance p1 to origin: " + p1.distanceToOrigin());
        System.out.println("Distance p2 to origin: " + p2.distanceToOrigin());
        p2.moveTo(p1);
        print(p1, p2);
        p1.moveTo(8, 9);
        print(p1, p2);
        DoublePoint p3 = p1.copy();
        print(p1, p2, p3);
        p3.moveTo(-2, 5); // should not affect p1
        print(p1, p2, p3);
        p3 = p1.opposite();
        print(p1, p2, p3);
        p3.moveTo(-3, 6); // should not affect p1
        print(p1, p2, p3);
    }
}
