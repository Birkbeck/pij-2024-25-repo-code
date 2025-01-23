public class SpyTester {
    public static void main(String[] args) {
        Spy alice = new Spy();
        Spy bob = new Spy();
        System.out.println("There are " + Spy.getNumberOfActiveSpies() + " active spies!");
    }
}
