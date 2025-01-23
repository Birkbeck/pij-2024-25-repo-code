public class Day5PointTester {
    public static void main(String[] args) {
        Day5Point point = new Day5Point(1,1);
        System.out.println("The point is now at " + point.getX() + "," + point.getY());
        Day5Point remotePoint = new Day5Point(10,20);
        point.moveTo(remotePoint);
        System.out.println("The point is now at " + point.getX() + "," + point.getY());
    }
}
