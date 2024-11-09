package a_parkinglot;

import a_parkinglot.vehicletype.Car;
import a_parkinglot.vehicletype.Vehicle;

public class ParkingLotDemo {
    
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(0, 20));
        parkingLot.addLevel(new Level(1, 20));
        parkingLot.displayAvailability();

        Vehicle myCar = new Car("ABC133");
        parkingLot.parkVehicle(myCar);
        parkingLot.unparkVehicle(myCar);

    }

}
