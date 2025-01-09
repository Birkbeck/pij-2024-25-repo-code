import java.util.Scanner;

public class Day3Exercise8 {
    public static void main(String[] args) {
        // First create the first rectangle itself...
        Day3Rectangle firstRectangle = new Day3Rectangle();
        // ...and then its corner points (we must do that explicitly, too):
        firstRectangle.upLeft = new Day3Point();
        firstRectangle.downRight = new Day3Point();

        // Now read the data to set up the rectangle's corner points
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the first x coordinate for the first rectangle: ");
        double x1 = scan.nextDouble();
        System.out.print("Please enter the second x coordinate for the first rectangle: ");
        double x2 = scan.nextDouble();
        System.out.print("Please enter the first y coordinate for the first rectangle: ");
        double y1 = scan.nextDouble();
        System.out.print("Please enter the second y coordinate for the first rectangle: ");
        double y2 = scan.nextDouble();

        // upLeft has small x (left) and big y (up)
        firstRectangle.upLeft.x = Math.min(x1, x2);
        firstRectangle.upLeft.y = Math.max(y1, y2);

        // downRight has big x (right) and small y (down)
        firstRectangle.downRight.x = Math.max(x1, x2);
        firstRectangle.downRight.y = Math.min(y1, y2);

        // First create the second rectangle itself...
        Day3Rectangle secondRectangle = new Day3Rectangle();
        // ...and then its corner points (we must do that explicitly, too):
        secondRectangle.upLeft = new Day3Point();
        secondRectangle.downRight = new Day3Point();

        // Now read the data to set up the rectangle's corner points
        System.out.print("Please enter the first x coordinate for the second rectangle: ");
        x1 = scan.nextDouble();
        System.out.print("Please enter the second x coordinate for the second rectangle: ");
        x2 = scan.nextDouble();
        System.out.print("Please enter the first y coordinate for the second rectangle: ");
        y1 = scan.nextDouble();
        System.out.print("Please enter the second y coordinate for the second rectangle: ");
        y2 = scan.nextDouble();

        // upLeft has small x (left) and big y (up)
        secondRectangle.upLeft.x = Math.min(x1, x2);
        secondRectangle.upLeft.y = Math.max(y1, y2);

        // downRight has big x (right) and small y (down)
        secondRectangle.downRight.x = Math.max(x1, x2);
        secondRectangle.downRight.y = Math.min(y1, y2);

        // Now let's create a fifth point.
        Day3Point point = new Day3Point();
        System.out.print("Please enter the x coordinate of the point: ");
        point.x = scan.nextDouble();
        System.out.print("Please enter the y coordinate of the point: ");
        point.y = scan.nextDouble();

        // Our fifth point is in the rectangle if it is between upLeft and
        // downRight both for the x coordinate and for the y coordinate

        boolean isInFirstRectangle = firstRectangle.upLeft.x <= point.x &&
                    point.x <= firstRectangle.downRight.x &&
                    firstRectangle.downRight.y <= point.y &&
                    point.y <= firstRectangle.upLeft.y;

        boolean isInSecondRectangle = secondRectangle.upLeft.x <= point.x &&
                    point.x <= secondRectangle.downRight.x &&
                    secondRectangle.downRight.y <= point.y &&
                    point.y <= secondRectangle.upLeft.y;

        if (isInFirstRectangle) {
            if (isInSecondRectangle) {
                System.out.println("The point is in BOTH rectangles.");
            } else {
                System.out.println("The point is only in the FIRST rectangle.");
            }
        } else {
            if (isInSecondRectangle) {
                System.out.println("The point is only in the SECOND rectangle.");
            } else {
                System.out.println("The point is in NONE OF the two rectangles.");
            }
        }
        // Note all the duplication in the above code... we will soon learn
        // about writing methods, which will help us reduce this duplication!
    }
}
