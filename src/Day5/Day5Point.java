public class Day5Point {
    private int x;
    private int y;

    public Day5Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveTo(Day5Point remote) {
        this.x = remote.x;
        this.y = remote.y;
    }
    // more methods here...

}
