package pij.day12.vehicles;

public class Car extends MotorVehicle {

    private Wheel leftFrontWheel;
    private Wheel rightFrontWheel;
    private Wheel leftRearWheel;
    private Wheel rightRearWheel;

    public Car(String ownerName) {
        super(ownerName);
        this.leftFrontWheel = new Wheel();
        this.rightFrontWheel = new Wheel();
        this.leftRearWheel = new Wheel();
        this.rightRearWheel = new Wheel();
    }

    @Override
    public double computeKW() {
        return 0; // TODO Auto-generated method stub
    }
}
