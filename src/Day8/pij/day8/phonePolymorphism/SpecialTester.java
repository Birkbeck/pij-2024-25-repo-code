package pij.day8.phonePolymorphism;

public class SpecialTester extends SimpleTester {
    public void test(OldPhone p) {
        System.out.println("special test old");
    }
    public void test(MobilePhone m) {
        System.out.println("special test mobile");
    }
    public void ring(MobilePhone m) {
        System.out.println("special ring mobile");
    }
}
