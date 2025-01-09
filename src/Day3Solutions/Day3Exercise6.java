import java.util.Scanner;

public class Day3Exercise6 {
    public static void main(String[] args) {
        // First create the rectangle itself...
        Day3Rectangle rectangle = new Day3Rectangle();
        // ...and then its corner points (we must do that explicitly, too):
        rectangle.upLeft = new Day3Point();
        rectangle.downRight = new Day3Point();

        // Now read the data to set up the rectangle's corner points
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the first x coordinate: ");
        double x1 = scan.nextDouble();
        System.out.print("Please enter the second x coordinate: ");
        double x2 = scan.nextDouble();
        System.out.print("Please enter the first y coordinate: ");
        double y1 = scan.nextDouble();
        System.out.print("Please enter the second y coordinate: ");
        double y2 = scan.nextDouble();

        // upLeft has small x (left) and big y (up)
        rectangle.upLeft.x = Math.min(x1, x2);
        rectangle.upLeft.y = Math.max(y1, y2);

        // downRight has big x (right) and small y (down)
        rectangle.downRight.x = Math.max(x1, x2);
        rectangle.downRight.y = Math.min(y1, y2);

        // Now let's get the ingredients for our calculations...
        double width = rectangle.downRight.x - rectangle.upLeft.x;
        double height = rectangle.upLeft.y - rectangle.downRight.y;

        // ...and compute the desired values:
        double area = width * height;
        double perimeter = 2 * (width + height);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}
