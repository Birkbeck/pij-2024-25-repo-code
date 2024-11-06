package pij.day12.vehicles;

public class PoliceCar extends Car implements HasSpecialRights {
    private int numberOfBlueLights;

    public PoliceCar(String ownerName, int numberOfBlueLights) {
        super(ownerName);
        this.numberOfBlueLights = numberOfBlueLights;
    }

    @Override
    public void toggleSpecialRights() {
        // TODO Auto-generated method stub
    }
}
