package d_elevator;

import d_elevator.Enums.Direction;
import d_elevator.Enums.ElevatorState;

public class ElevatorCar {
    int id;
    ElevatorDisplay elevatorDisplay;
    InternalButtons internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;

    public ElevatorCar(){
        elevatorDisplay = new ElevatorDisplay(0, Direction.UP);
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = Direction.UP;
        elevatorDoor = new ElevatorDoor();
    }
    
    

}
