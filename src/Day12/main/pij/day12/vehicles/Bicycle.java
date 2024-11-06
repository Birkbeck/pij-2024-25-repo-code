package pij.day12.vehicles;

public class Bicycle extends Vehicle {

    private double tyreInches;

    public Bicycle(String ownerName, double tyreInches) {
        super(ownerName);
        this.tyreInches = tyreInches;
    }
}
