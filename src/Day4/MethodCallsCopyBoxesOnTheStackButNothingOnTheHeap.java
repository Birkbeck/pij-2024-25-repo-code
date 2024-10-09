public class MethodCallsCopyBoxesOnTheStackButNothingOnTheHeap {
    static void increment(UniPoint point, int n) {
        n = n + 1;
        point.x = point.x + 1;
        point = null;
    }

    public static void main(String[] args) {
        UniPoint myPoint = new UniPoint();
        myPoint.x = 8;
        int myInt = 8;
        increment(myPoint, myInt);
        System.out.println("The integer is now " + myInt);
        System.out.println("The point is now " + myPoint.x);
    }
}