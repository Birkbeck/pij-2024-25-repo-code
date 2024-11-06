package pij.day12.vehicles;

public class CrewTransporter extends MotorVehicle implements HasPassengers, HasSpecialRights {

    private int numberOfBenches;

    public CrewTransporter(String ownerName, int numberOfBenches) {
        super(ownerName);
        this.numberOfBenches = numberOfBenches;
    }

    @Override
    public int getPassengerCount() {
        return 0; // TODO Auto-generated method stub
    }

    @Override
    public void toggleSpecialRights() {
        // TODO Auto-generated method stub
    }

    @Override
    public double computeKW() {
        return 0; // TODO Auto-generated method stub
    }
}
