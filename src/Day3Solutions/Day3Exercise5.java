import java.util.Scanner;

public class Day3Exercise5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Day3Point p1 = new Day3Point();
        System.out.print("Please enter the x coordinate of point 1: ");
        p1.x = scan.nextDouble();
        System.out.print("Please enter the y coordinate of point 1: ");
        p1.y = scan.nextDouble();
        Day3Point p2 = new Day3Point();
        System.out.print("Please enter the x coordinate of point 2: ");
        p2.x = scan.nextDouble();
        System.out.print("Please enter the y coordinate of point 2: ");
        p2.y = scan.nextDouble();
        Day3Point p3 = new Day3Point();
        System.out.print("Please enter the x coordinate of point 3: ");
        p3.x = scan.nextDouble();
        System.out.print("Please enter the y coordinate of point 3: ");
        p3.y = scan.nextDouble();

        // a lot of repeated code... soon we will see how we can write
        // our own methods to reuse code that we have written once
        double x12Diff = p1.x - p2.x;
        double y12Diff = p1.y - p2.y;
        double distance12 = Math.sqrt(x12Diff*x12Diff + y12Diff*y12Diff);

        double x13Diff = p1.x - p3.x;
        double y13Diff = p1.y - p3.y;
        double distance13 = Math.sqrt(x13Diff*x13Diff + y13Diff*y13Diff);

        double x23Diff = p2.x - p3.x;
        double y23Diff = p2.y - p3.y;
        double distance23 = Math.sqrt(x23Diff*x23Diff + y23Diff*y23Diff);

        if (distance12 <= distance13 && distance12 <= distance23) {
            System.out.println("Minimum distance " + distance12 + " between Point 1 and Point 2!");
        } else if (distance13 <= distance12 && distance13 <= distance23) {
            System.out.println("Minimum distance " + distance13 + " between Point 1 and Point 3!");
        } else { // only a single option remains
            System.out.println("Minimum distance " + distance23 + " between Point 2 and Point 3!");
        }
    }
}
