package pij.day8.phonePolymorphism;

import pij.day8.SimpleTester;

public class TesterMain {
    public static void main(String[] args) {
        OldPhone old = new OldPhone("ACME classic");
        MobilePhone mobile = new MobilePhone("ACME");
        OldPhone mobileAsOld = mobile;

        SimpleTester simple = new SimpleTester();
        SpecialTester special = new SpecialTester();
        SimpleTester specialAsSimple = special;

        simple.test(old);
        simple.test(mobile);
        simple.test(mobileAsOld);
        System.out.println();

        special.test(old);
        special.test(mobile);
        special.test(mobileAsOld);
        System.out.println();

        specialAsSimple.test(old);
        specialAsSimple.test(mobile);
        specialAsSimple.test(mobileAsOld);
        System.out.println();

        simple.ring(old);
        simple.ring(mobile);
        simple.ring(mobileAsOld);
        System.out.println();

        special.ring(old);
        special.ring(mobile);
        special.ring(mobileAsOld);
        System.out.println();

        specialAsSimple.ring(old);
        specialAsSimple.ring(mobile);
        specialAsSimple.ring(mobileAsOld);
    }
}
