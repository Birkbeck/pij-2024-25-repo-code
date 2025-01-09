public class DoublePoint {
    double x;
    double y;

    double distanceTo(DoublePoint other) {
        // the distance from (x,y) to (x',y') is
        // sqrt( (x-x')*(x-x') + (y-y')*(y-y') )
        double xDiff = this.x - other.x;
        double yDiff = this.y - other.y;
        double sum = xDiff * xDiff + yDiff * yDiff;
        return Math.sqrt(sum);
    }

    double distanceToOrigin() {
        DoublePoint origin = new DoublePoint();
        origin.x = 0;
        origin.y = 0;
        return distanceTo(origin);
    }

    void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void moveTo(DoublePoint other) {
        moveTo(other.x, other.y);
    }

    DoublePoint copy() {
        DoublePoint result = new DoublePoint();
        result.x = this.x;
        result.y = this.y;
        return result;
    }

    DoublePoint opposite() {
        DoublePoint result = new DoublePoint();
        result.x = - this.x;
        result.y = - this.y;
        return result;
    }
}
