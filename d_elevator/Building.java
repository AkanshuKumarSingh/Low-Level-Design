package d_elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floorList;

    Building(List<Floor> floors){
        floorList = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public void removeFloor(Floor floor) {
        floorList.remove(floor);
    }

}
