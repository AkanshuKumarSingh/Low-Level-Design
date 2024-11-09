package a_parkinglot;

import java.util.ArrayList;
import java.util.List;

import a_parkinglot.vehicletype.Vehicle;
import a_parkinglot.vehicletype.VehicleType;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;
    
    public Level(int floor, int numSpots){
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);

        // Assign spots in ration of 50:40:10 for bikes, cars and trucks
        double spotsForBikes = 0.50;
        double spotsForCars = 0.40;

        int numBikes = (int) (numSpots * spotsForBikes);
        int numCars = (int) (numSpots * spotsForCars);
        
        for(int i = 1; i <= numBikes; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }

        for(int i = numBikes+1; i <= numBikes + numCars; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i = numCars+numBikes+1; i <= numSpots; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getType()){
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpots){
            if(!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)){
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailaibility(){
        System.out.println("Level" + floor + " Avalaibility:");
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.isAvailable()){
                System.out.println("Spot:" + parkingSpot.getSpotNumber() + " available for " + parkingSpot.getVehicleType());
            }
        }
    }

}
