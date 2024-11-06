package pij.day12.vehicles;

public interface HasFarePassengers extends HasPassengers {
    double computeFare(String destination);
}
