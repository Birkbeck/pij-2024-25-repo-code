public class Horse implements Measurable {
    private double height;
    public Horse(double height) {
        this.height = height;
    }

    @Override
    public double getMeasure() {
        return height;
    }
}
