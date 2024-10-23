package pij.day8.phonePolymorphism;

public class SmartPhone extends MobilePhone {
    private static final String INTERNATIONAL_PREFIX = "00";

    public SmartPhone(String brand) {
        super(brand);
    }

    public void browseWeb(String address) {
        System.out.println("Browsing " + address + "...");
    }

    public void findPosition() {
        System.out.println("Coordinates TO DO");
    }

    @Override
    public void call(String number) {
        if (number.startsWith(INTERNATIONAL_PREFIX)) {
            System.out.println("Calling " + number + " through the internet to save money");
        } else {
            super.call(number);
        }
    }
}
