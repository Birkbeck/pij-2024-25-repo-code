package pij.day9solutions.phones;

import pij.day8.phonePolymorphism.Phone;

import java.util.Objects;

public class OldPhone implements Phone {

    private String brand;

    public OldPhone(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    @Override
    public void call(String number) {
        System.out.println("Calling " + number + "...");
    }

    // Exercise 4.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        OldPhone oldPhone = (OldPhone) o;
        // Objects.equals can deal with null
        return Objects.equals(this.brand, oldPhone.brand);
    }

    // Exercise 6. Comment out the method to see the "weird" behaviour
    // in Exercise 5.
    @Override
    public int hashCode() {
        // Objects.hashCode can deal with null
        return Objects.hashCode(this.brand);
    }
}
