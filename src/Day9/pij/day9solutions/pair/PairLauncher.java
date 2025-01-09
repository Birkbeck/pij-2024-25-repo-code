package pij.day9solutions.pair;

public class PairLauncher {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Hello", 42);

        // now possible!
        Pair<Object, Integer> p2 = new Pair(p1);
    }
}
