package d_elevator;

import d_elevator.Enums.Direction;

public class ExternalButton {
    ExternalDispatcher dispatcher = new ExternalDispatcher();

    int[] availableButtons = {1,2,3,4,5,6,7,8,9,10};
    int buttonSelected;

    void pressButton(int floorNumber, Direction direction) {

        //1.check if destination is in the list of available floors

        //2.submit the request to the jobDispatcher
        dispatcher.submitExternalRequest(floorNumber, direction);
    }
}
