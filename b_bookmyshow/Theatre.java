package b_bookmyshow;

import java.util.ArrayList;
import java.util.List;

import b_bookmyshow.Enums.City;

public class Theatre {
    
    int theatrId;
    String address;
    City city;
    List<Screen> screen = new ArrayList<>();
    List<Show> show = new ArrayList<>();
    
    public Theatre(int theatrId, String address, City city, List<Screen> screen, List<Show> show) {
        this.theatrId = theatrId;
        this.address = address;
        this.city = city;
        this.screen = screen;
        this.show = show;
    }
    
    public void addShow(Show s){
        show.add(s);
    }

    public int getTheatrId() {
        return theatrId;
    }
    public void setTheatrId(int theatrId) {
        this.theatrId = theatrId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public List<Screen> getScreen() {
        return screen;
    }
    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }
    public List<Show> getShow() {
        return show;
    }
    public void setShow(List<Show> show) {
        this.show = show;
    }
    

}
