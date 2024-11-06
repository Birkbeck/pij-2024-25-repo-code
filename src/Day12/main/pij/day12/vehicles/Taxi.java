package pij.day12.vehicles;

public class Taxi extends Car implements HasFarePassengers {
    private int maxPassengers;

    public Taxi(String ownerName, int maxPassengers) {
        super(ownerName);
        this.maxPassengers = maxPassengers;
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
