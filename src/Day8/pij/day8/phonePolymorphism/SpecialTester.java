package pij.day8.phonePolymorphism;

import pij.day8.MobilePhone;
import pij.day8.SimpleTester;

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
