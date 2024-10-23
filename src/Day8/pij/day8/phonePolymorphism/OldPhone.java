package pij.day8.phonePolymorphism;

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

}
