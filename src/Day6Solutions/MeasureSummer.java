public class MeasureSummer {
    public static double sumMeasures(Measurable[] measurables) {
        double runningTotal = 0;
        for (int i = 0; i < measurables.length; i++) {
            runningTotal += measurables[i].getMeasure();
        }
        return runningTotal;
    }
}
