package b_bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    List<Seat> seats = new ArrayList<>();
    int screenId;
    
    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }
    public int getscreenId() {
        return screenId;
    }
    public void setscreenId(int screenId) {
        this.screenId = screenId;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    


}
