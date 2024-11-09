package a_parkinglot;

import a_parkinglot.vehicletype.Vehicle;
import a_parkinglot.vehicletype.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(parkedVehicle == null){
            parkedVehicle = vehicle;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public void unparkVehicle(){
        parkedVehicle = null;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

}
