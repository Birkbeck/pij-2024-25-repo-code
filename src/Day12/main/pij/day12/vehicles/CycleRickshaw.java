package pij.day12.vehicles;

public class CycleRickshaw extends Bicycle implements HasFarePassengers {
    private int maxKG;

    public CycleRickshaw(String ownerName, double tyreInches, int maxKG) {
        super(ownerName, tyreInches);
        this.maxKG = maxKG;
    }

    @Override
    public double computeFare(String destination) {
        return 0; // TODO Auto-generated method stub
    }

    @Override
    public int getPassengerCount() {
        return 0; // TODO Auto-generated method stub
    }
}
