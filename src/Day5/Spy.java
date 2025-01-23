public class Spy {
    private static int activeSpyCount = 0;

    public Spy() {
        activeSpyCount++;
        // ...
    }

    public static int getNumberOfActiveSpies() {
        return activeSpyCount;
    }
    // ...
}
