package pij.day7solutions.phones;

import pij.day7.phones.Phone;

public class OldPhone implements Phone {
    @Override
    public void call(String number) {
        System.out.println("Calling " + number + "...");
    }
}
