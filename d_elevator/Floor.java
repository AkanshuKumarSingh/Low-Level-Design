package d_elevator;

import d_elevator.Enums.Direction;

public class Floor {
    int floorNumber;
    ExternalButton externalButton;
    
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.externalButton = new ExternalButton();
    }

    public void pressButton(Direction direction) {
        externalButton.pressButton(floorNumber, direction);
    }

}
